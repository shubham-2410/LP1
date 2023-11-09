import RPi.GPIO as GPIO
import time
High =1
Low=0
DetectPin =5
RUNNING=True
def initSystem():
    GPIO.setmode(GPIO.BCM)
    GPIO.setup(DetectPin , GPIO.IN.pull_up_down = GPIO.PUD_UP)
    return

def detectPerson():
    state = GPIO.input()
    time.sleep(0.3)
    if(state==0):
        return Low
    else:
        return High
    
try:
    initSystem()
    print("\n-------Counting-------\n")
    count=0
    while RUNNING:
        state =detectPerson()
        if(state==High):
            count+=1
            print("Person Count= %d" %count)
except KeyboardInterrupt:
    RUNNING=False
finally:
    GPIO.cleanup()        