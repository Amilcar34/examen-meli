class Message {
  constructor(messageAsBits, standardMessageAsBits, from, recipient) {
    this.from = from;
    this.recipient = recipient;
    this.bitMessage = {};
    this.bitMessage.standardMessage = standardMessageAsBits;
    this.bitMessage.message = messageAsBits;
  }
}