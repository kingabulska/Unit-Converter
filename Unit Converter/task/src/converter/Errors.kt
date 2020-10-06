package converter


class ParseError(message: String): IllegalArgumentException(message)

class WrongUnitError: IllegalArgumentException("Parse error")