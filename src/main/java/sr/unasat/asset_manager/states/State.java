package sr.unasat.asset_manager.states;

import sr.unasat.asset_manager.entity.Asset;
import sr.unasat.asset_manager.entity.Status;

public interface State {
    Status getStatus(Asset asset);
}
