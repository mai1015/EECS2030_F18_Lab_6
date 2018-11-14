import java.util.ArrayList;
import java.util.List;

/**
 * A weather statistics app calculates the 
 * minimum, maximum, and average temperature 
 * read so far from its subscribed weather station, if any.
 */
public class StatisticsApp extends WeatherObserver {

	private List<Double> data = new ArrayList<>();
	private double total;
	private double min;
	private double max;
	private double ave;

	private WeatherStation station;
	/**
	 * Update the reading of this weather observer.
	 * Update the current temperature and the 
	 * maximum, minimum, and average accordingly.
	 */
	public void update() {
		/* Your Task */
		if (station == null) return;
		double cur = station.getTemperature();
		data.add(cur);
		total += cur;
		ave = total / data.size();
		if (data.size() == 1) {
			max = cur;
			min = cur;
		}
		if (cur > max)
			max = cur;
		if (cur < min)
			min = cur;
	}

	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		/* Your Task */
		return station;
	}

	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		/* Your Task */
		station = ws;
	}

	/**
	 * Get the minimum temperature based on the readings so far.
	 * @return minimum temperature based on the readings so far
	 */
	public double getMinTemperature() {
		/* Your Task */
		return min;
	}

	/**
	 * Get the maximum temperature based on the readings so far.
	 * @return maximum temperature based on the readings so far
	 */
	public double getMaxTemperature() {
		/* Your Task */
		return max;
	}

	/**
	 * Get the average temperature based on the readings so far.
	 * @return average temperature based on the readings so far
	 */
	public double getAverageTemperature() {
		/* Your Task */
		return ave;
	}
}

