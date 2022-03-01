package BLL;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {
	int orderId;
	int clientId;
	LocalDateTime date;

	public Order(int orderId, int clientId, LocalDateTime date) {
		this.orderId = orderId;
		this.clientId = clientId;
		this.date = date;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return orderId + " " + date.format(DateTimeFormatter.ISO_DATE_TIME);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Order))
			return false;
		Order order = (Order) o;
		return orderId == order.orderId && clientId == order.clientId && Objects.equals(date, order.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, clientId, date);
	}
}
