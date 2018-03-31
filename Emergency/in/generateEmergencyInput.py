import random

PROB_NAME = "emergency"
NUM_TESTFILES = 100
MAX_TESTCASES = 50
MAX_ANTENNARANGE = 100
MAX_NUMHOUSES = 100
MIN_HOUSEDISTANCE = 0.25
MAX_HOUSEDISTANCE = 4

for testNum in range(1, NUM_TESTFILES+1):

    testFilename = PROB_NAME + str(testNum) + ".in"
    out = open(testFilename, 'w')
    testCases = random.randint(1, MAX_TESTCASES+1)
    out.write(str(testCases) + "\n")

    for testCase in range(testCases):
        numHouses = random.randint(1, MAX_NUMHOUSES+1)
        antennaRange = random.randint(1, MAX_ANTENNARANGE+1)

        housePositions = list()
        prevHousePos = 1
        currHousePos = 0
        for house in range(1, numHouses+1):
            
            currHousePos = random.randint(prevHousePos + (int)(MIN_HOUSEDISTANCE * antennaRange), prevHousePos + (int)(MAX_HOUSEDISTANCE * antennaRange))
            housePositions.append(currHousePos)
            prevHousePos = currHousePos

        out.write(str(numHouses) + " " + str(antennaRange) + "\n")
        for house in housePositions[:-1]:
            out.write(str(house) + " ")
        out.write(str(housePositions[-1]) + 2*"\n")
