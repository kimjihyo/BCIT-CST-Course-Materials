question1 = function() {
  result = c(1:20)
  true_mean = mean(TenMileRace$net)
  print(true_mean)
  for (i in (1:20)) {
    racetimes20 = TenMileRace$net[sample(1:8636, 25)]
    r = t.test(racetimes20)
    result[i] = true_mean > r$conf.int[1] && true_mean < r$conf.int[2]
  }
  print(sum(result == 1) / length(result))
}

generateSentence = function(alpha, data, target, unit) {
  r = t.test(data, conf.level = alpha)
  lowerbound = r$conf.int[1]
  upperbound = r$conf.int[2]
  CIsetnence = cat("We are", alpha * 100, "percent sure that the mean of", target, "is between", lowerbound, "and", upperbound, unit)
}

confidence = function(data, conflevel) {
  r = t.test(data, conf.level = alpha)
  lowerbound = r$conf.int[1]
  upperbound = r$conf.int[2]
  CIsetnence = cat("We are", alpha * 100, "percent sure that the mean is between", lowerbound, "and", upperbound)
}

confidence = function(data, alpha=0.95, target, unit) {
  r = t.test(data, conf.level = alpha)
  lowerbound = r$conf.int[1]
  upperbound = r$conf.int[2]
  CIsetnence = cat("We are", alpha * 100, "percent sure that the mean of", target, "is between", lowerbound, "and", upperbound, unit)
}