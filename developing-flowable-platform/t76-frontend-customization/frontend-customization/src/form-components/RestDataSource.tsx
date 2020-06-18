import React from 'react';
import {_, Model} from '@flowable/forms';

type RestDataSourceProps = {};

// Custom Component which demonstrates how to implement "invisible" components which interact wi.
// The component will fetch the data specified in the extra setting "dataurl" and then stores it
// in the bound value.
class RestDataSource extends Model.FormComponent {

  constructor(props: Model.Props) {
    super(props);
  }

  // As soon as the company mounts, fetch the data.
  async componentDidMount(): Promise<void> {
    const { $path, extraSettings } = this.props.config;
    const url = _.get(extraSettings, 'dataurl');

    if($path && url){
      let response = await fetch(url);
      let responseValue = await response.json();
      this.props.onChange(responseValue);
    }
  }

  // No need to render anything.
  render() {
    return <>
      </>;
  }
}

export default RestDataSource;
