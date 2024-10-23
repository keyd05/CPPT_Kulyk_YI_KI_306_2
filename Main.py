from MobilePhone import MobilePhone
from Phone import Phone

from Display import Display
from Battery import Battery
from Processor import Processor

if __name__ == "__main__":
    display = Display("AMOLED", 6.5)
    battery = Battery(4500)
    processor = Processor("Exynos", 8)

    phone_number = "+380634567890"
    mobile_phone = MobilePhone()

    print("Display Type:", mobile_phone.get_display_type())
    print("Battery Capacity:", mobile_phone.get_battery_capacity(), "mAh")
    print("Processor Type:", mobile_phone.get_processor_type())

    mobile_phone.make_call("+38063456154")
    mobile_phone.send_sms("+38063456154", "Hello, how are you?")
    mobile_phone.receive_sms("I'm good, thanks!")