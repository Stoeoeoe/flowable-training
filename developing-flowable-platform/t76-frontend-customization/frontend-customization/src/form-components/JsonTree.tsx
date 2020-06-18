import React from 'react';
import {_, Model} from '@flowable/forms';
import ReactJson from 'react-json-view';

// Custom Component which displays a JSON Tree of the bound value
class JsonTreeComponent extends Model.FormComponent {
  render() {
      return <>
        <ReactJson src={this.props.config.value}/>
      </>;
  }
}

export default JsonTreeComponent;
