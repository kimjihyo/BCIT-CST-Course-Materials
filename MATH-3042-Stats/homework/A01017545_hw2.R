# Jihyo Kim A01017545 3M 
serviceTimes = function(m, serviceRate) {
  serviceTimes = rexp(m, serviceRate)
  return(cbind(serviceTimes))
}

arrivalTimes = function(m, arrivalRate) {
  arrivalTimes = rexp(m, arrivalRate)
  for(i in (1:(m-1))) {
    arrivalTimes[i + 1] = arrivalTimes[i + 1] + arrivalTimes[i] 
  }
  return(cbind(arrivalTimes))
}

waitTimes = function(m, arrivalRate, serviceRate) {
  serviceTimes = serviceTimes(m, serviceRate)
  arrivalTimes = arrivalTimes(m, arrivalRate)
  leavingTimes = rep(0, m)
  waitingTimes = rep(0, m)
  for(i in (1:(m-1))) {
    leavingTimes[i] = serviceTimes[i] + arrivalTimes[i] + waitingTimes[i]
    waitingTimes[i + 1] = max(leavingTimes[i] - arrivalTimes[i + 1], 0)
  }
  leavingTimes[m] = serviceTimes[m] + arrivalTimes[m] + waitingTimes[m]
  return(cbind(arrivalTimes, waitingTimes, serviceTimes, leavingTimes))
}

simulateWaits = function(m, arrivalRate, serviceRate, n, maxWait) {
  result = c(1:m)
  for (i in (1:n)) {
    waitingTimes = waitTimes(m, arrivalRate, serviceRate)[, "waitingTimes"]
    result[i] =  sum(waitingTimes>maxWait)
  }
  return(sum(result>0)/length(result))
}