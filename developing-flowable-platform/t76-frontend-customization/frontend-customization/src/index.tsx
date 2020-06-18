import React from 'react';

import {ExternalAppComponentProps, ExternalApplication} from '@flowable/work';

import {detailCustomizations} from './customizations/details';
import './themes/flowable/index.scss';
import StarRating from "./form-components/StarRating";
import RestDataSource from "./form-components/RestDataSource";
import {StarWarsApp} from "./apps/starWarsApp";
import {StarWarsTwitterApp} from "./apps/starWarsTwitterApp";
import {getHeaderCustomizations} from "./headers/Headers";

// Importing JSX files is possible as well but the error message must be ignored if there are no typings.
// @ts-ignore
import JsonTreeComponent from "./form-components/JsonTree";
import TileComponent from "./form-components/TileComponent";

function createApps(): ExternalApplication[] {
  return [
    {
      applicationId: 'star-wars',
      label: 'Star Wars API',
      icon: 'sitemap/solid',
      component: (props: ExternalAppComponentProps) => <StarWarsApp {...props} />,
      sub: [
        {
          applicationId: 'star-wars',
          label: 'Dashboard',
          icon: 'sitemap/solid',
          component: (props: ExternalAppComponentProps) => <StarWarsApp {...props}/>
        },
        {
          applicationId: 'star-wars-twitter',
          label: 'Twitter',
          icon: 'sitemap/solid',
          component: (props: ExternalAppComponentProps) => <StarWarsTwitterApp {...props}/>
        }
      ]
    }
  ];
}


const applications = createApps();
const formComponents = [
  ['starRatingComponent', StarRating],
  ['jsonTreeComponent', JsonTreeComponent],
  ['restDataSource', RestDataSource],
  ['tile', TileComponent],

];

const headerCustomizations = getHeaderCustomizations();

export default { applications, detailCustomizations, formComponents };
