class Display:
    def __init__(self, display_type, size):
        self.type = display_type
        self.size = size

    def get_type(self):
        return self.type

    def set_type(self, display_type):
        self.type = display_type

    def get_size(self):
        return self.size