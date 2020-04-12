FlipOnce = function()
{
  HeadOrTail<-sample(c("Heads", "Tails"), 1)
  return(HeadOrTail)
}

CoinResults = function(n)
{
  return(sample(c("Heads", "Tails"), n, replace=TRUE))
}

ProbHeads = function(n)
{
  coinList <- CoinResults(n)
  numHeads <- sum(coinList=="Heads")
  return(numHeads / n)
}

MaxAndMinHeads = function(n, m)
{
  maxProb = 0
  minProb = 1
  for (i in 1:m)
  {
    prob = ProbHeads(n)
    if (prob > maxProb)
    {
      maxProb = prob
    }
    if (prob < minProb)
    {
      minProb = prob
    }
  }
  return(c(maxProb, minProb))
}

RollDie = function(n)
{
  result = sample(1:6, n, replace=TRUE)
  t = table(result)
  barplot(t, xlab="dice", ylab="frequencies", main=sprintf("Distribution of outcomes of %d die rolls", n))
  return (result)
}

RollSomeDice = function(n, m)
{
  dieRollList = c(1:m)
  {
    for (i in 1:m)
    {
      dr = sample(c(1,2,3,4,5,6), n, repl=T)
      dieRollList[i] = sum(dr == 3)
    }
  }
  title = sprintf("Number of 3's obtained rolling %d dice", m)
  barplot(table(dieRollList), main=title, xlab="number of 3's", ylab="number of samples")
}

DrawCardsWithReplacement = function(n, m)
{
  r = "red"
  b = "blue"
  redCards = rep(r, 26)
  blueCards = rep(b, 26)
  deck = c(redCards, blueCards)
  
  numsOfDrawnRedCards = rep(0, n)
  for (i in 1:n)
  {
    drawn = sample(deck, m, replace = TRUE)
    numOfDrawnRedCards = sum(drawn == "red")
    numsOfDrawnRedCards[i] = numOfDrawnRedCards
  }
  
  t = table(numsOfDrawnRedCards)
  title = sprintf("Number of red cards drawn from %d cards", m)
  barplot(t, main=title, xlab="number of red cards drawn", ylab="number of samples")
}
DrawCardsWithoutReplacement = function(n, m)
{
  r = "red"
  b = "blue"
  redCards = rep(r, 26)
  blueCards = rep(b, 26)
  deck = c(redCards, blueCards)
  
  numsOfDrawnRedCards = rep(0, n)
  for (i in 1:n)
  {
    drawn = sample(deck, m, replace = FALSE)
    numOfDrawnRedCards = sum(drawn == "red")
    numsOfDrawnRedCards[i] = numOfDrawnRedCards
  }
  
  t = table(numsOfDrawnRedCards)
  title = sprintf("Number of red cards drawn from %d cards", m)
  barplot(t, main=title, xlab="number of red cards drawn", ylab="number of samples")
}