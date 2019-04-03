# 交大官网F12分析

## 简介

本文利用chrome的F12开发者工具对交大官网（[www.sjtu.edu.cn](https://www.sjtu.edu.cn))进行各项性能分析，借此熟悉F12工具的使用方法，了解web页面优化的相关知识。此外，本文还将交大官网与清华官网（[www.tsinghua.edu.cn](www.tsinghua.edu.cn))进行技术上的比较。

![Snipaste_2019-04-02_12-52-13](imgs\Snipaste_2019-04-02_12-52-13.png)

![Snipaste_2019-04-02_19-18-02](imgs\Snipaste_2019-04-02_19-18-02.png)

## Chrome F12开发者工具

开发者工具的界面如下图所示：
![Snipaste_2019-04-02_12-45-31](imgs\Snipaste_2019-04-02_12-45-31.png)

Chrome的F12页面是一个成熟的web前端debug与性能分析工具集。可以看到界面中包含以下几个子选单，接下来笔者将使用这些工具依次进行分析。

## Elements

Elements就是debug时最常用的检查工具。交大官网主页内容丰富，且使用了大量动态效果，对于动态效果可以进行一下分析：

![animation](imgs\animation.gif)

在elements中可以看到动画使用了CSS3特性，动画具有良好的性能。

![Snipaste_2019-04-02_19-06-59](imgs\Snipaste_2019-04-02_19-06-59.png)

相对来说，清华大学的网站虽然有独具一格的美观设计，在动态效果上还是略逊一筹。

## Performance

性能选单为开发者提供了对网页进行CPU占用、渲染与内存管理等方面监控记录的能力。通过profile功能，chrome游览器可以按时间顺序记录网页的活动情况，并给出火焰图。通过火焰图我们可以很直观地分析出网页的性能瓶颈，优化网页的响应速度。现在我们通过性能选单分析网页加载时的性能表现。

![Snipaste_2019-04-02_12-52-46](imgs\Snipaste_2019-04-02_12-52-46.png)

通过Summary中的饼图可以清晰地看到网页加载过程中scripting与rendering占据了最多的时间。由于首页图片较多，render所用时间较多情有可原，我们重点分析scripting所占时间。通过bottom-up选单我们可查看每个在火焰图上的事件所消耗的时间并可排序显示，方便我们分析性能瓶颈。

![Snipaste_2019-04-02_13-12-38](imgs\Snipaste_2019-04-02_13-12-38.png)

在FCP(First Contentful Paint)之前，500ms到700ms间有一段Evaluate Script，其中有大量`document.writeln`，是比较昂贵的操作。进一步分析发现这段在`headersys.js`中的JS代码使用了大量`document.writeln`操作绘制了页面的顶部工具栏。由于看不出有什么特殊原因，这段html应该静态地与页面一同加载才对。

![Snipaste_2019-04-02_13-10-59](imgs\Snipaste_2019-04-02_13-10-59.png)

在FCP与DCL(DOM Content Loaded)之间也有大量的scripting，但基本都是在加载jquery框架与使用到的外部插件。通过call tree分析可知，占用时间最多的是自己写的脚本`main.js`，其中加载了所有的相关插件并进行了配置。

![Snipaste_2019-04-02_13-28-08](imgs\Snipaste_2019-04-02_13-28-08.png)

除此之外，可以从时间线上看到在FCP之前有大量的web request用于加载图片。这些笔者将在Network这一节中继续分析。

清华大学网站主页与交大网站主页相比，内容较少，首次渲染也比交大主页快，但是由于首页轮播图容量大，全页加载完成慢于交大主页。

![Snipaste_2019-04-02_19-25-20](imgs\Snipaste_2019-04-02_19-25-20.png)

## Network

Network工具专门用于分析网页运行的网络活动。这里分析交大网站主页加载时的网络活动。以下图片是笔者在公用无线网络环境下测得的，最后一个request完成于约6000ms时。

![Snipaste_2019-04-02_18-28-43](imgs\Snipaste_2019-04-02_18-28-43.png)

可以看到，虽然总大小只有10MB不到，但游览器总共发起了105个request，对于首页加载来说请求数目太多了，用户在较差的网络环境下游览体验会急剧下降。以下是Chrome游览器模拟`Fast 3G`网络环境下的首页加载情况，可以看到完成所有request使用了约50秒：

![Snipaste_2019-04-02_18-33-50](imgs\Snipaste_2019-04-02_18-33-50.png)

经分析发现，105个request中约一半是在请求图片。对于这些资源可使用lazy load，加快首页加载时间。剩下的一半都是CSS与JS，可考虑使用Webpack等工具打包为单个CSS/JS文件减少请求数量。

此外注意到主页调用的API接口，可看到属性名晦涩难懂，会给后期维护带来困难：

![Snipaste_2019-04-02_18-40-21](imgs\Snipaste_2019-04-02_18-40-21.png)

最后在Request Header中也未见CSRF Token，难以抵御CSRF攻击。

![Snipaste_2019-04-02_18-42-23](imgs\Snipaste_2019-04-02_18-42-23.png)

清华主页也有类似的问题：

![Snipaste_2019-04-02_19-26-25](imgs\Snipaste_2019-04-02_19-26-25.png)

对于6.4MB的数据使用了56个request，这个请求的密度与交大主页差不多。另外，首页轮播大图的加载占用了大量的时间，对首页加载时间的影响很大。其实对于除去第一张的后几张轮播图，可采用lazy load的方式，可以加快网页加载速度。

![Snipaste_2019-04-02_19-26-44](imgs\Snipaste_2019-04-02_19-26-44.png)

由于清华主页request数量较少，在弱网络环境下情况不如交大主页糟糕。

![Snipaste_2019-04-02_19-33-46](imgs\Snipaste_2019-04-02_19-33-46.png)

## Sources

Sources工具可为开发者展现网站目录结构。可以看到网站的目录结构还是十分清晰的，但未使用Webpack等工具，应该只是单纯的web开发套件中的模板引擎。

![Snipaste_2019-04-02_18-46-15](imgs\Snipaste_2019-04-02_18-46-15.png)

清华的主页也类似，只不过以hash命名的图片数据与前端数据未良好分离：

![Snipaste_2019-04-02_19-29-37](imgs\Snipaste_2019-04-02_19-29-37.png)

## Memory

Memory工具用于监视内存使用情况。交大主页使用的内存在20M左右，还是可以接受的。清华主页所使用内存在12M左右。

## Application

Application工具用于监视html5 LocalStorage API, Web SQL， Session Storage与PWA相关的互联网应用功能。由于交大主页并未使用到相关技术，本工具中没有相关信息。

## Security

Security工具由于查看网站的连接安全情况，可以看到交大网站使用了HTTPS，极为安全，而清华主页则**未采用HTTPS**，今年已经2019年了，这可以说是不可接受的。

## Audits

Audits是新版Chrome中新加入的工具，这个工具可以智能地为网站用户体验进行打分。

![Snipaste_2019-04-02_19-13-35](imgs\Snipaste_2019-04-02_19-13-35.png)

可以看到这个工具打分还是很严格的，交大网站即便在校内加载很快，在performance方面也只得到了13分。在opportunities页面中可以看到chrome提供了很多图片加载优化的建议，与先前笔者的分析一致。

![Snipaste_2019-04-02_19-13-35](imgs\Snipaste_2019-04-02_19-13-35.png)

下图是清华主页的分数。可见交大的新主页还需要进一步维护优化。

![Snipaste_2019-04-02_19-31-44](imgs\Snipaste_2019-04-02_19-31-44.png)