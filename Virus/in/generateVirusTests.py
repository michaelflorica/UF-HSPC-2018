import random

PROB_NAME = "virus"
NUM_TESTFILES = 100

MIN_TESTCASES_PER_TESTFILE = 5
MAX_TESTCASES_PER_TESTFILE = 10

MIN_NUM_COMPUTERS = 10
MAX_NUM_COMPUTERS = 100

def generate_different_pair(numComputers):
    comp1 = random.randint(1, numComputers)
    comp2 = random.randint(1, numComputers)

    while(comp2 == comp1):
        comp2 = random.randint(1, numComputers)

    return (comp1,comp2)

#NUM_RELATIONSHIPS = random.randint(MIN_NUM_COMPUTERS/2, MAX_NUM_COMPUTERS/2)
#NUM_PROTECTED = random.randint(MIN_NUM_COMPUTERS/2, MAX_NUM_COMPUTERS/2)
for testFile in range(1, NUM_TESTFILES+1):

    testFilename = PROB_NAME + str(testFile) + ".in"
    out = open(testFilename, 'w')

    testCases = random.randint(MIN_TESTCASES_PER_TESTFILE, MAX_TESTCASES_PER_TESTFILE)
    out.write(str(testCases) + "\n")

    for testCase in range(1, testCases+1):
        numComputers = random.randint(MIN_NUM_COMPUTERS, MAX_NUM_COMPUTERS)
        out.write(str(numComputers) + " ")

        protectedComputers = set()
        numProtected = random.randint(int(numComputers/4), int(numComputers/2))
        out.write(str(numProtected) + "\n")

        for protected in range(1, numProtected+1):
            comp = random.randint(1, numComputers)
            while comp in protectedComputers:
                comp = random.randint(1, numComputers)
            protectedComputers.add(comp)
            out.write(str(comp) + "\n")

        relationships = set()
        numRelationships = random.randint(int(numComputers/4), int(numComputers/2))
        out.write(str(numRelationships) + "\n")

        for relationship in range(1, numRelationships+1):
            pair = generate_different_pair(numComputers)
            while pair in relationships:
                pair = generate_different_pair(numComputers)

            out.write(str(pair[0]) + " " + str(pair[1]) + "\n")
            reversedPair = (pair[1], pair[0])
            relationships.add(pair)
            relationships.add(reversedPair)

        compromisedComputers = set()
        numCompromised = random.randint(0, numComputers-numProtected)
        out.write(str(numCompromised) + "\n")

        for compromised in range(1, numCompromised+1):
            comp = random.randint(1, numComputers)
            while comp in protectedComputers or comp in compromisedComputers:
                comp = random.randint(1, numComputers)

            out.write(str(comp) + "\n")
            compromisedComputers.add(comp)

        out.write("\n")
'''
for i in xrange(NUM_TESTS):
    TEST_NAME = 'virusIN' + str(i+1) + '.in'


    out = open(TEST_NAME, 'w')
    out.write("1\n")
    out.write(str(NUM_COMPUTERS) + "\n")


    seen = set()
    out.write(str(NUM_PROTECTED) + "\n")
    for j in xrange(NUM_PROTECTED):
        a = random.randint(1, NUM_COMPUTERS)
        while a in seen:
            a = random.randint(1, NUM_COMPUTERS)
        seen.add(a)
        out.write(str(a) + "\n")


    seen = set()
    out.write(str(NUM_RELATIONSHIPS) + "\n")
    for j in xrange(NUM_RELATIONSHIPS):
        a = random.randint(1, NUM_COMPUTERS - 1)
        b = random.randint(a, NUM_COMPUTERS)
        while (a, b) in seen:
            a = random.randint(1, NUM_COMPUTERS - 1)
            b = random.randint(a, NUM_COMPUTERS)
        seen.add((a, b))
        out.write(str(a) + " " + str(b) + "\n")


    seen = set()
    out.write(str(NUM_COMPROMISED) + "\n")
    for j in xrange(NUM_COMPROMISED):
        a = random.randint(1, NUM_COMPUTERS)
        while a in seen:
            a = random.randint(1, NUM_COMPUTERS)

        seen.add(a)
        out.write(str(a) + "\n")

    out.write("\n")
'''
