from Phone import Phone

class MobilePhone(Phone):
    def __init__(self, display, battery, processor, phone_number):
        super().__init__(display, battery, processor)
        self.phone_number = phone_number

    def make_call(self, number):
        self.set_battery_capacity(self.get_battery_capacity() - 30)
        print(f"Calling to {number} from {self.phone_number}.")

    def send_sms(self, number, message):
        self.set_battery_capacity(self.get_battery_capacity() - 15)
        print(f"Sending SMS to {number}: {message}")

    def receive_sms(self, message):
        self.set_battery_capacity(self.get_battery_capacity() - 5)
        print(f"Received SMS: {message}")
