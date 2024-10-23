class Processor:
    def __init__(self, model, cores):
        self.model = model
        self.cores = cores

    def get_model(self):
        return self.model

    def set_model(self, model):
        self.model = model

    def get_cores(self):
        return self.cores

    def set_cores(self, cores):
        self.cores = cores