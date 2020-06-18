import React from 'react';
import { _, Model } from '@flowable/forms';
import './tileComponent.scss';

type TileDefinition = {text: string, value: string};

class TileComponent extends Model.StatefulFormComponent {

    tileLookup: {[elementValue: string]: JSX.Element} = {};

    createTiles(tiles: TileDefinition[], orientation: "row" | "column"): JSX.Element {
        const tileComponents: JSX.Element[] = [];

        for (let tile of tiles) {
            const disabled = !this.props.config.enabled;
            const selected = this.props.config.value === tile.value;
            const bem = this.bem("tile", {disabled, selected});

            const tileComponent =
                <div
                    key={tile.value}
                    onClick={() => this.selectTile(tile.value)}
                    className={bem()} >

                    {tile.text}
                </div>;
            tileComponents.push(tileComponent);
            this.tileLookup[tile.value] = tileComponent;
        }
        const tileContainer = <div className="tile-container" style={{flexDirection: orientation}}>{tileComponents}</div>;
        return tileContainer;
    }

    selectTile(tileValue: string) {
        this.setState({clickedElement: tileValue});
        this.props.onChange(tileValue);
    }

    render() {
        const {config} = this.props;
        const { value, defaultValue } = this.props.config;
        const tiles = _.get(config.extraSettings, 'tiles');
        const orientation = _.get(config.extraSettings, 'orientation');


        const tileComponents = this.createTiles(tiles, orientation);

        if(value || defaultValue) {
            this.selectTile(value || defaultValue)
        }

        return (
            tileComponents
        );
    }
}

export default TileComponent;