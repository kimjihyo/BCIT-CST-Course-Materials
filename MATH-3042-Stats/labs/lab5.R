rollDice = function(m, n) {
  results = c(1:n)
  for (i in c(1:n)) {
    result = sum(sample(c(1:6), m, replace=TRUE)==3)
    results[i] = result
  }
  print(table(results) / n)
  main = sprintf("Probability for the number of 3’s for %d rolls of %d dice", n, m)
  barplot(table(results) / n, xlab="Number of 3's got", ylab="Frequencies",
          main=main)
}

rollDiceRbinom = function(m, n) {
  results = rbinom(n, m, 1/6)
  numthrees = table(results)
  main = sprintf("Probability for the number of 3’s for %d rolls of %d dice", n, m)
  print(numthrees / n)
  barplot(numthrees / n, xlab="Number of 3's got", ylab="Frequencies",
          main=main)
}

getDistri = function(n) {
  results <- c(0:n)
  print(results)
  for (i in c(0:n)) {
    results[i + 1] = dhyper(i, 4, 48, 8)
  }
  return (results)
}

probNumberOfAces = function(m, n) {
  r = c(1:n)
  for (i in c(1:n)) {
    r[i] = sum(sample(c(1:52), m, FALSE) <= 4)
  }
  my_t = table(r) / n
  print(my_t)
  barplot(my_t, xlab="The number of aces drawn", ylab="Frequencies", main="Probability distribution of # aces drawn")
}

probNumberOfAcesHyper = function(m, n) {
  result = rhyper(n, 4, 48, m)
  t = table(result) / n
  print(t)
  barplot(t, xlab="The number of aces drawn", ylab="Frequencies", main="Probability distribution of # aces drawn")
}

lottery = function(n) {
  students = c(1:n)
  for (i in 1:n) {
    count = 1
    while (sample(c(1:5)) != 1) {
      count = count + 1
    }
    students[i] = count;
  }
  barplot(table(students),main = "# purchases for lottery", xlab="# purchases", ylab="# students");
  return(table(students));
}
