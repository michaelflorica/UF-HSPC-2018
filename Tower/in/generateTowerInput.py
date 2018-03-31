PROB_NAME = "tower"

HOUR = 0 
MIN = 1

out = open("tower1.in", 'w')

out.write("1440")
out.write("\n00:00")
while (HOUR != 0 or MIN != 0):
    out.write("\n")
    minuteString = ""
    if MIN < 10:
        minuteString = "0" + str(MIN)
    else:
        minuteString = str(MIN)

    hourString = ""
    if HOUR < 10:
        hourString = "0" + str(HOUR)
    else:
        hourString = str(HOUR)

    out.write(hourString + ":" + minuteString)

    MIN = (MIN + 1) % 60
    if(MIN == 0):
        HOUR = (HOUR + 1) % 24
