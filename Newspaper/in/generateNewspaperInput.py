import random

NUM_TESTFILES = 100
PROB_NAME = "newspaper"

for testNum in range(1, NUM_TESTFILES+1):

    testFilename = PROB_NAME + str(testNum) + ".in"
    out = open(testFilename, 'w')
    testCases = random.randint(1, 100)
    out.write(str(testCases) + "\n")

    for testCase in range(testCases):
        N = random.randint(1, 100000)
        S = random.randint(2, 20000)
        L = random.randint(1, S-1)

        prob = random.random()  # [0, 1.0)
        if(prob <= 0.04):       # 4% prob of -1 output
            W = S*N + random.randint(1, 1000)
        else:
            W = random.randint(1, S*N-1)

        out.write(str(N) + " " + str(S) + " " + str(L) + " " + str(W) + "\n")
