package sr.unasat.asset_manager.states;

import sr.unasat.asset_manager.entity.Asset;
import sr.unasat.asset_manager.entity.Status;

public class WrittenOffState implements State {
    @Override
    public Status getStatus(Asset asset) {
        return asset.getStatus();
    }
}
