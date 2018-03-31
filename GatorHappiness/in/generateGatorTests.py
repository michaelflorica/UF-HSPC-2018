from __future__ import print_function
import random

NUM_TESTS = 100
MAX_TESTS_PER_FILE = 10
MAP_WIDTH = 100
MAP_HEIGHT = 50


NEW_LAKE_CHANCE = 0.05
CONTINUE_LAKE_CHANCE_ALL_THREE = 0.8
CONTINUE_LAKE_CHANCE_BOTH = 0.8
CONTINUE_LAKE_CHANCE_LEFT = 0.5
CONTINUE_LAKE_CHANCE_ABOVE = 0.5
ANIMAL_CHANCE = 0.05

ANIMALS = ['B', 'P', 'D']

print("GENERATING TESTS")

def getNeighbors((i, j)):
    neighbors = []

    for a in xrange(-1, 2):
        for b in xrange(-1, 2):
            if (a == 0 and b == 0) or i+a < 0 or i+a >= MAP_HEIGHT or j+b < 0 or j+b >= MAP_WIDTH: 
                continue
            else:
                neighbors.append((i+a, j+b))
    return neighbors


for i in xrange(NUM_TESTS):
    print("GENERATING TEST " + str(i+1))

    TEST_NAME = 'gatorhappiness' + str(i+1) + '.in'
    
    test_count = random.randint(1, MAX_TESTS_PER_FILE)
    
    out = open(TEST_NAME, 'w')
    out.write(str(test_count) + "\n")
    
    
    for j in xrange(test_count):
        out.write(str(MAP_HEIGHT) + " " + str(MAP_WIDTH) + "\n")


        # PASS 1: insert water tiles randomly
        map = [['L' for i in xrange(MAP_WIDTH)] for i in xrange(MAP_HEIGHT)]
        for a in xrange(MAP_HEIGHT):
            for b in xrange(MAP_WIDTH):
                # calculate lake chance
                lake_chance = NEW_LAKE_CHANCE
                
                if a > 0 and map[a-1][b] == 'W' and b > 0 and map[a][b-1] == 'W' and map[a-1][b-1] == 'W':
                    lake_chance = CONTINUE_LAKE_CHANCE_ALL_THREE
                elif a > 0 and map[a-1][b] == 'W' and b > 0 and map[a][b-1] == 'W':
                    lake_chance = CONTINUE_LAKE_CHANCE_BOTH
                elif a > 0 and map[a-1][b] == 'W':
                    lake_chance = CONTINUE_LAKE_CHANCE_ABOVE
                elif b > 0 and map[a][b-1] == 'W':
                    lake_chance = CONTINUE_LAKE_CHANCE_LEFT
                if random.random() < lake_chance:
                    map[a][b] = 'W'

        # PASS 2: put animals randomly on the shore
        for a in xrange(MAP_HEIGHT):
            for b in xrange(MAP_WIDTH):
                if map[a][b] == 'W':
                    continue
                has_water_neighbor = False
                has_land_neighbor = False

                for ni, nj in getNeighbors((a, b)):
                    if map[ni][nj] == 'W':
                        has_water_neighbor = True
                    elif map[ni][nj] == 'L':
                        has_land_neighbor = True
                
                
                # if current square has both land and water neighbor
                # it is considered shore
                if (not has_land_neighbor) or (not has_water_neighbor):
                    continue
                
                if random.random() < ANIMAL_CHANCE:
                    map[a][b] = random.sample(ANIMALS, 1)[0]


        for row in map:
            for elt in row:
                out.write(elt)
            out.write("\n")

print("DONE")
