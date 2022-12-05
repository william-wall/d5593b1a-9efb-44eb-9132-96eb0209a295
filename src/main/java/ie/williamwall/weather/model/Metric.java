package ie.williamwall.weather.model;

import java.util.Comparator;
import java.util.List;

public class Metric {

	private String type;
	private Double minimum;
	private Double maximum;
	private Double average;
	private Double total;

	public Metric(String metric, List<Double> metricValues) {
		this.type = metric;
		this.minimum = metricValues.stream().min(Comparator.naturalOrder()).get();
		this.maximum = metricValues.stream().max(Comparator.naturalOrder()).get();
		this.average = metricValues.stream().mapToDouble(a -> a).average().orElse(0.0);
		this.total = metricValues.stream().mapToDouble(t -> t.doubleValue()).sum();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getMinimum() {
		return minimum;
	}

	public void setMinimum(Double minimum) {
		this.minimum = minimum;
	}

	public Double getMaximum() {
		return maximum;
	}

	public void setMaximum(Double maximum) {
		this.maximum = maximum;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
