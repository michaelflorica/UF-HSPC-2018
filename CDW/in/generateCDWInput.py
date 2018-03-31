import random

PROB_NAME = "cdw"
NUM_TESTFILES = 100

MIN_TESTCASES_PER_TESTFILE = 50
MAX_TESTCASES_PER_TESTFILE = 100

MIN_NUM_COMPANIES = 10
MAX_NUM_COMPANIES = 30
MIN_EVENT_TIME = 10
MAX_EVENT_TIME = 300

for testFile in range(1, NUM_TESTFILES+1):

    testFilename = PROB_NAME + str(testFile) + ".in"
    out = open(testFilename, 'w')

    testCases = random.randint(MIN_TESTCASES_PER_TESTFILE, MAX_TESTCASES_PER_TESTFILE)
    out.write(str(testCases) + "\n\n")

    for testCase in range(1, testCases+1):
        numCompanies = random.randint(MIN_NUM_COMPANIES, MAX_NUM_COMPANIES)
        eventTime = random.randint(MIN_EVENT_TIME,MAX_EVENT_TIME)
        out.write(str(numCompanies) + " " + str(eventTime) + "\n");

        for company in range(1, numCompanies+1):
            companyValue = random.randint(10, 50)
            companyTime = random.randint(MIN_EVENT_TIME, MAX_EVENT_TIME)
            out.write(str(companyValue) + " " + str(companyTime))
            out.write("\n")

        out.write("\n")
