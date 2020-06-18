import {DetailCustomizations, DetailCustomizationType, emptyDetailCustomizations} from '@flowable/work';

import {caseDetailCustomizations} from './caseDetails';

// Here you can add all customizations.
export const detailCustomizations = (element: any, type: DetailCustomizationType): Promise<DetailCustomizations> => {

    if (type === 'case') {
        return caseDetailCustomizations(element);
    } else if (type === 'process') {
        return Promise.resolve({externalTabs: {}, tabOverrides: {}});
    } else if(type === 'task') {
        return Promise.resolve({externalTabs: {}, tabOverrides: {}});
    }

    return Promise.resolve({externalTabs: {}, tabOverrides: {}});
};
