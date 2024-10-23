from Display import Display
from Battery import Battery
from Processor import Processor

class Phone:
    def __init__(self, display=None, battery=None, processor=None):
        self.display = display or Display("OLED", 6.1)
        self.battery = battery or Battery(4000)
        self.processor = processor or Processor("Snapdragon", 8)

    def make_call(self, number):
        self.battery.set_capacity(self.battery.get_capacity() - 30)
        print(f"Calling to {number}.")

    def get_display_type(self):
        return self.display.get_type()

    def set_display_type(self, display_type):
        self.display.set_type(display_type)

    def get_battery_capacity(self):
        return self.battery.get_capacity()

    def set_battery_capacity(self, capacity):
        self.battery.set_capacity(capacity)

    def get_processor_type(self):
        return self.processor.get_model()

    def set_processor_type(self, model):
        self.processor.set_model(model)
