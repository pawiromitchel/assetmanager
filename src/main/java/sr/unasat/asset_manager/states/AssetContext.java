package sr.unasat.asset_manager.states;

import sr.unasat.asset_manager.entity.Asset;
import sr.unasat.asset_manager.entity.Status;

public class AssetContext {
    private State state;

    public AssetContext() {
    }

    public void setStatus(Asset asset){
        if(asset.getStatus().getStatus().equals("Registered")){
            this.state = new RegisteredState();
        }
        if(asset.getStatus().getStatus().equals("Written-Off")){
            this.state = new WrittenOffState();
        }
    }

    public Status getState(Asset asset) {
        return state.getStatus(asset);
    }
}
