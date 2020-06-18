import React from 'react';

import {CaseInstance, DetailCustomizations, ExternalTab, TypeBadgeCustomization} from '@flowable/work';

// Changes all "Case" badges so that they display the caseInstanceId.
async function caseTypeBadgeCustomization(element: CaseInstance): Promise<TypeBadgeCustomization> {
    return Promise.resolve({
        label: `Case with id ${element.id}`,
        iconName: 'sitemap/solid'
    });
}

// Add and change tabs for cases
function caseTabsCustomization(element: CaseInstance): Promise<DetailCustomizations> {

    // Add new tabs with custom content.
    const externalTabs: { [tabId: string]: ExternalTab } = {
        progress: {
            label: 'My custom tab',
            icon: 'tachometer',
            order: 1,
            component: () => (<div>Add your custom content here for case instance {element.id}</div>)
        }
    };

    // Change the order and hide existing tabs
    const tabOverrides: { [tabId: string]: Partial<ExternalTab> } = {
        task: {
            order: 999,
            hidden: true
        },
        workForm: {
            hidden: true
        },
        people: {
            hidden: true
        },
        subItems: {
            hidden: true
        },
        history: {
            hidden: true
        }
    };

    const detailCustomizations = Promise.resolve({externalTabs, tabOverrides});
    return detailCustomizations;
}

// Collect all case customizations
export async function caseDetailCustomizations(element: Element): Promise<DetailCustomizations> {
    const [{externalTabs, tabOverrides}, typeBadge] = await Promise.all([
        caseTabsCustomization(element),
        caseTypeBadgeCustomization(element)
    ]);
    return {externalTabs, tabOverrides, typeBadge};
}
