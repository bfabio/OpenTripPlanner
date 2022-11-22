package org.opentripplanner.gtfs.graphbuilder;

import java.net.URI;
import java.util.Optional;
import org.opentripplanner.graph_builder.model.DataSourceConfig;
import org.opentripplanner.transit.model.site.StopTransferPriority;

/**
 * Configure a GTFS feed.
 * Example: {@code [ {type="gtfs", source: "file:///path/to/otp/norway-gtfs.zip"} ] }
 */
public class GtfsFeedParameters implements DataSourceConfig {

  public static final boolean DEFAULT_REMOVE_REPEATED_STOPS = true;

  public static final StopTransferPriority DEFAULT_STATION_TRANSFER_PREFERENCE =
    StopTransferPriority.ALLOWED;

  public static final boolean DEFAULT_DISCARD_MIN_TRANSFER_TIMES = false;

  private final URI source;
  private final String feedId;
  private final boolean removeRepeatedStops;
  private final StopTransferPriority stationTransferPreference;
  private final boolean discardMinTransferTimes;

  GtfsFeedParameters(GtfsFeedParametersBuilder builder) {
    this.source = builder.source();
    this.feedId = builder.feedId();
    this.removeRepeatedStops = builder.removeRepeatedStops();
    this.stationTransferPreference = builder.stationTransferPreference();
    this.discardMinTransferTimes = builder.discardMinTransferTimes();
  }

  /** See {@link org.opentripplanner.standalone.config.buildconfig.TransitFeedConfig}. */
  @Override
  public URI source() {
    return source;
  }

  /** See {@link org.opentripplanner.standalone.config.buildconfig.TransitFeedConfig}. */
  public Optional<String> feedId() {
    return Optional.ofNullable(feedId);
  }

  public boolean removeRepeatedStops() {
    return removeRepeatedStops;
  }

  public StopTransferPriority stationTransferPreference() {
    return stationTransferPreference;
  }

  public boolean discardMinTransferTimes() {
    return discardMinTransferTimes;
  }

  public GtfsFeedParametersBuilder copyOf() {
    return new GtfsFeedParametersBuilder(this);
  }
}
