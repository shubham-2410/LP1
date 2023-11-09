import time
import RPi.GPIO as GPIO

RUNNING=True
led1=20
led2=21
led3=22
led3=23
led4=23
led5=24
led6=25
led7=26
led8=27

led=[led1 , led2 , led3 , led4 ,led5 , led6 , led7 , led8]

GPIO.setmode(GPIO.BCM)
GPIO.setup(led1 , GPIO.OUT)
GPIO.setup(led2 , GPIO.OUT)
GPIO.setup(led3 , GPIO.OUT)
GPIO.setup(led4 , GPIO.OUT)
GPIO.setup(led5 , GPIO.OUT)
GPIO.setup(led6 , GPIO.OUT)
GPIO.setup(led7 , GPIO.OUT)
GPIO.setup(led8 , GPIO.OUT)

def ledState(l , a):
    GPIO.output(led[l] , a)

try:
    for i in (8):
        ledState(i , 1)
    while(RUNNING):
        for i in 8:
            ledState(i , 1)
            time.sleep(0.5)
            ledState(i , 0)
            time.sleep(i , 0.5)
except KeyboardInterrupt:
    RUNNING=False
finally:
    GPIO.cleanup()