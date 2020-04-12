DiceMeans = function(n, m) {
  means = c(1:n)
  for (i in c(1:n)) {
    r = sample(c(1:6), m, replace = TRUE)
    means[i] = mean(r)
  }
  mean = mean(means)
  sd = sd(means)
  print(mean)
  print(sd)
  barplot(table(means), xlab="means", ylab="# samples", main=sprintf("Distribution of sample means (m=%d)", m))
}

GetBatteriesCanBeShiped = function(n) {
  r = rnorm(n, mean=9.01, sd=0.05)
  return (sum(r <= 9.1 & r >= 8.9))
}

NormalMeans = function(n, m) {
  samples = c(1:n);
  for (i in 1:n) {
    r = rnorm(m, mean=0, sd=1);
    samples[i] = mean(r);
  }
  print(mean(samples))
  print(sd(samples))
  hist(samples, main=sprintf("Normal Distributions m=%d", m))
}