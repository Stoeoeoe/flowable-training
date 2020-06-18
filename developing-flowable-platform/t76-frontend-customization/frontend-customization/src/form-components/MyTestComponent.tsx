import React from 'react';
import insertCss from 'insert-css'
import {_, Model} from '@flowable/forms';


class MyTestComponent extends Model.FormComponent {

    render() {
        const { config } = this.props;
        const world: string = _.get(config, 'extraSettings.world', "mars");
        this.props.onChange('HOI ZÄME');



        return <div>
            <p>Hello {world}</p>
        </div>
    }


}

export default MyTestComponent;