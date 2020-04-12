NormalMeansProb = function(n, m, x) {
  samples = c(1:n);
  for (i in 1:n) {
    r = rnorm(m, mean=0, sd=1);
    sum = 0
    counter = 0
    for (n in r) {
      if (abs(n) <= abs(x)) {
        sum = sum + n
        counter = counter + 1 
      }
    }
    samples[i] = sum / counter
  }
  print(mean(samples))
  print(sd(samples))
  hist(samples, main=sprintf("Normal Distributions m=%d x=%f", m, x))
}

ExponentialMeans = function(n, m) {
  samples = c(1:n);
  for (i in 1:n) {
    r = rexp(m, 1)
    samples[i] =  mean(r)
  }
  mean = mean(samples)
  sd = sd(samples)
  print(mean)
  print(sd)
  hist(samples, main=sprintf("Exponential means(n=%d, m=%d)", n, m))
}

ExponentialMeansProb = function(n, m, x) {
  samples = c(1:n);
  for (i in 1:n) {
    r = rexp(m, 1)
    sum = 0
    counter = 0
    for (a in r) {
      if (a >= 1-x && a <= 1+x) {
        sum = sum + a
        counter = counter + 1 
      }
    }
    samples[i] = sum / counter
  }
  print(mean(samples))
  print(sd(samples))
  hist(samples, main=sprintf("Exponential Distributions (n=%d, m=%d x=%f)", n, m, x))
}