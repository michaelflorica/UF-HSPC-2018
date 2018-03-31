import random
import string

PROB_NAME = "link"
NUM_TESTFILES = 100

MIN_TESTCASES_PER_TESTFILE = 10
MAX_TESTCASES_PER_TESTFILE = 50

MIN_NUMCOMMANDS = 10
MAX_NUMCOMMANDS = 300

MIN_FILE_NAME_LENGTH = 3
MAX_FILE_NAME_LENGTH = 10

TOUCH_PROBABILITY = 0.3
LINK_PROBABILITY = 0.4


def generate_filename(chars = string.ascii_lowercase + string.digits):
    return ''.join(random.choice(chars) for _ in range(MIN_FILE_NAME_LENGTH, MAX_FILE_NAME_LENGTH))


for testFile in range(1, NUM_TESTFILES+1):

    testFilename = PROB_NAME + str(testFile) + ".in"
    out = open(testFilename, 'w')

    testCases = random.randint(MIN_TESTCASES_PER_TESTFILE, MAX_TESTCASES_PER_TESTFILE)
    out.write(str(testCases) + "\n\n")

    for testCase in range(1, testCases+1):
        
        existingFiles = set()
        numCommands = random.randint(MIN_NUMCOMMANDS, MAX_NUMCOMMANDS+1)
        out.write(str(numCommands) + "\n")

        for command in range(numCommands):
            fileName = generate_filename()

            while fileName in existingFiles:
                fileName = generate_filename()

            rand = random.random()

            if rand < TOUCH_PROBABILITY or len(existingFiles) == 0:
                out.write("touch " + fileName + "\n")
                existingFiles.add(fileName)

            elif rand < TOUCH_PROBABILITY + LINK_PROBABILITY:
                existingFile = random.sample(existingFiles, 1)[0]
                out.write("link " + existingFile + " " + fileName + "\n")
                existingFiles.add(fileName)

            else:
                existingFile = random.sample(existingFiles, 1)[0]
                out.write("rm " + existingFile + "\n")
                existingFiles.remove(existingFile)

        out.write("\n")
