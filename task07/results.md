```
# default parameters
timeoutmillis = 2.5s
nThreads = 10
average process time: 250ms(with standard diviation of 30^2)
```

[TOC]

# threshold = 10000(no stack)

Concurrency Level:      50
Time taken for tests:   25.277 seconds
Complete requests:      1000
Failed requests:        0
Non-2xx responses:      1000
Total transferred:      67000 bytes
HTML transferred:       0 bytes
Requests per second:    39.56 [#/sec] (mean)
Time per request:       1263.836 [ms] (mean)
Time per request:       25.277 [ms] (mean, across all concurrent requests)
Transfer rate:          2.59 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.5      0       3
Processing:   231 1231 136.9   1251    1429
Waiting:      231 1231 136.9   1251    1429
Total:        234 1232 136.5   1251    1430

Percentage of the requests served within a certain time (ms)
  50%   1251
  66%   1271
  75%   1284
  80%   1293
  90%   1317
  95%   1333
  98%   1356
  99%   1377
 100%   1430 (longest request)

---

Concurrency Level:      100
Time taken for tests:   25.222 seconds
Complete requests:      1000
Failed requests:        0
Non-2xx responses:      1000
Total transferred:      67000 bytes
HTML transferred:       0 bytes
Requests per second:    39.65 [#/sec] (mean)
Time per request:       2522.228 [ms] (mean)
Time per request:       25.222 [ms] (mean, across all concurrent requests)
Transfer rate:          2.59 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   1.3      0       6
Processing:   184 2398 411.6   2504    2738
Waiting:      184 2398 411.6   2504    2738
Total:        190 2398 410.4   2504    2741

Percentage of the requests served within a certain time (ms)
  50%   2504
  66%   2524
  75%   2537
  80%   2545
  90%   2567
  95%   2588
  98%   2605
  99%   2614
 100%   2741 (longest request)

---

Concurrency Level:      200
Time taken for tests:   22.379 seconds
Complete requests:      908
Failed requests:        184
   (Connect: 0, Receive: 92, Length: 0, Exceptions: 92)
Non-2xx responses:      816
Total transferred:      54672 bytes
HTML transferred:       0 bytes
Requests per second:    40.57 [#/sec] (mean)
Time per request:       4929.287 [ms] (mean)
Time per request:       24.646 [ms] (mean, across all concurrent requests)
Transfer rate:          2.39 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   23 146.0      0    1022
Processing:   215 2535 481.0   2683    2846
Waiting:        0 2279 904.1   2682    2845
Total:        226 2557 500.5   2686    3717

Percentage of the requests served within a certain time (ms)
  50%   2686
  66%   2712
  75%   2728
  80%   2737
  90%   2765
  95%   2791
  98%   3543
  99%   3544
 100%   3717 (longest request)

# threshold = 20
Concurrency Level:      50
Time taken for tests:   26.071 seconds
Complete requests:      981
Failed requests:        38
   (Connect: 0, Receive: 19, Length: 0, Exceptions: 19)
Non-2xx responses:      962
Total transferred:      64454 bytes
HTML transferred:       0 bytes
Requests per second:    37.63 [#/sec] (mean)
Time per request:       1328.774 [ms] (mean)
Time per request:       26.575 [ms] (mean, across all concurrent requests)
Transfer rate:          2.41 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.3      0       3
Processing:   202  753 307.2    772    2655
Waiting:        0  702 190.8    768     932
Total:        202  753 307.3    772    2656

Percentage of the requests served within a certain time (ms)
  50%    772
  66%    790
  75%    801
  80%    810
  90%    834
  95%    859
  98%    932
  99%   2656
 100%   2656 (longest request)

---
Concurrency Level:      100
Time taken for tests:   23.645 seconds
Complete requests:      930
Failed requests:        140
   (Connect: 0, Receive: 70, Length: 0, Exceptions: 70)
Non-2xx responses:      860
Total transferred:      57620 bytes
HTML transferred:       0 bytes
Requests per second:    39.33 [#/sec] (mean)
Time per request:       2542.449 [ms] (mean)
Time per request:       25.424 [ms] (mean, across all concurrent requests)
Transfer rate:          2.38 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   28 165.6      0    1024
Processing:   179  757 577.8    728    2609
Waiting:        0  566 321.0    710    2271
Total:        179  785 670.3    728    3534

Percentage of the requests served within a certain time (ms)
  50%    728
  66%    757
  75%    773
  80%    783
  90%    850
  95%   2518
  98%   3533
  99%   3533
 100%   3534 (longest request)

---
Concurrency Level:      200
Time taken for tests:   17.883 seconds
Complete requests:      828
Failed requests:        344
   (Connect: 0, Receive: 172, Length: 0, Exceptions: 172)
Non-2xx responses:      656
Total transferred:      43952 bytes
HTML transferred:       0 bytes
Requests per second:    46.30 [#/sec] (mean)
Time per request:       4319.525 [ms] (mean)
Time per request:       21.598 [ms] (mean, across all concurrent requests)
Transfer rate:          2.40 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   89 285.7      0    1010
Processing:   181  907 906.7    384    2779
Waiting:        0  370 344.1    305    2779
Total:        181  996 1095.2    385    3729

Percentage of the requests served within a certain time (ms)
  50%    385
  66%    709
  75%    764
  80%   2503
  90%   2579
  95%   3580
  98%   3728
  99%   3729
 100%   3729 (longest request)

# threshold = 10
Concurrency Level:      50
Time taken for tests:   25.455 seconds
Complete requests:      971
Failed requests:        58
   (Connect: 0, Receive: 29, Length: 0, Exceptions: 29)
Non-2xx responses:      942
Total transferred:      63114 bytes
HTML transferred:       0 bytes
Requests per second:    38.15 [#/sec] (mean)
Time per request:       1310.743 [ms] (mean)
Time per request:       26.215 [ms] (mean, across all concurrent requests)
Transfer rate:          2.42 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.3      0       3
Processing:   192  541 363.8    521    2549
Waiting:        0  465 133.0    519     670
Total:        192  541 364.0    521    2551

Percentage of the requests served within a certain time (ms)
  50%    521
  66%    541
  75%    554
  80%    561
  90%    586
  95%    611
  98%   2524
  99%   2533
 100%   2551 (longest request)

---
Concurrency Level:      100
Time taken for tests:   24.265 seconds
Complete requests:      917
Failed requests:        166
   (Connect: 0, Receive: 83, Length: 0, Exceptions: 83)
Non-2xx responses:      834
Total transferred:      55878 bytes
HTML transferred:       0 bytes
Requests per second:    37.79 [#/sec] (mean)
Time per request:       2646.150 [ms] (mean)
Time per request:       26.461 [ms] (mean, across all concurrent requests)
Transfer rate:          2.25 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   1.0      0       6
Processing:   198  562 628.6    377    2542
Waiting:        0  333 143.7    342    2300
Total:        198  562 629.2    377    2544

Percentage of the requests served within a certain time (ms)
  50%    377
  66%    424
  75%    445
  80%    462
  90%    521
  95%   2528
  98%   2542
  99%   2543
 100%   2544 (longest request)

---
Concurrency Level:      200
Time taken for tests:   17.097 seconds
Complete requests:      821
Failed requests:        358
   (Connect: 0, Receive: 179, Length: 0, Exceptions: 179)
Non-2xx responses:      642
Total transferred:      43014 bytes
HTML transferred:       0 bytes
Requests per second:    48.02 [#/sec] (mean)
Time per request:       4164.988 [ms] (mean)
Time per request:       20.825 [ms] (mean, across all concurrent requests)
Transfer rate:          2.46 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   94 294.1      0    1023
Processing:   166  846 953.4    325    2916
Waiting:        0  280 266.1    289    2630
Total:        166  940 1151.0    326    3937

Percentage of the requests served within a certain time (ms)
  50%    325
  66%    455
  75%    575
  80%   2511
  90%   2561
  95%   3795
  98%   3798
  99%   3936
 100%   3937 (longest request)

# threshold = 5

Concurrency Level:      50
Time taken for tests:   25.481 seconds
Complete requests:      965
Failed requests:        70
   (Connect: 0, Receive: 35, Length: 0, Exceptions: 35)
Non-2xx responses:      930
Total transferred:      62310 bytes
HTML transferred:       0 bytes
Requests per second:    37.87 [#/sec] (mean)
Time per request:       1320.245 [ms] (mean)
Time per request:       26.405 [ms] (mean, across all concurrent requests)
Transfer rate:          2.39 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       1
Processing:   191  428 426.3    339    2734
Waiting:        0  337 141.3    331    2734
Total:        191  428 426.4    339    2734

Percentage of the requests served within a certain time (ms)
  50%    338
  66%    372
  75%    395
  80%    412
  90%    449
  95%    498
  98%   2542
  99%   2542
 100%   2734 (longest request)

---

Concurrency Level:      100
Time taken for tests:   21.533 seconds
Complete requests:      915
Failed requests:        170
   (Connect: 0, Receive: 85, Length: 0, Exceptions: 85)
Non-2xx responses:      830
Total transferred:      55610 bytes
HTML transferred:       0 bytes
Requests per second:    42.49 [#/sec] (mean)
Time per request:       2353.339 [ms] (mean)
Time per request:       23.533 [ms] (mean, across all concurrent requests)
Transfer rate:          2.52 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   1.0      0       6
Processing:   181  536 640.6    332    2552
Waiting:        0  302 137.2    316    1912
Total:        182  536 641.2    332    2552

Percentage of the requests served within a certain time (ms)
  50%    332
  66%    366
  75%    389
  80%    407
  90%    470
  95%   2514
  98%   2523
  99%   2529
 100%   2552 (longest request)

---

Concurrency Level:      200
Time taken for tests:   17.179 seconds
Complete requests:      816
Failed requests:        368
   (Connect: 0, Receive: 184, Length: 0, Exceptions: 184)
Non-2xx responses:      632
Total transferred:      42344 bytes
HTML transferred:       0 bytes
Requests per second:    47.50 [#/sec] (mean)
Time per request:       4210.576 [ms] (mean)
Time per request:       21.053 [ms] (mean, across all concurrent requests)
Transfer rate:          2.41 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   3.2      0      11
Processing:   158  810 928.5    316    2728
Waiting:        0  245 196.9    284    2728
Total:        158  812 930.5    316    2729

Percentage of the requests served within a certain time (ms)
  50%    316
  66%    355
  75%    419
  80%   2504
  90%   2512
  95%   2519
  98%   2533
  99%   2537
 100%   2729 (longest request)

