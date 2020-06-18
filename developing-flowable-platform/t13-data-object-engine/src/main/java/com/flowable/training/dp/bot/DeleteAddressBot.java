package com.flowable.training.dp.bot;

import com.flowable.action.api.bot.BaseBotActionResult;
import com.flowable.action.api.bot.BotActionResult;
import com.flowable.action.api.bot.BotService;
import com.flowable.action.api.history.HistoricActionInstance;
import com.flowable.action.api.repository.ActionDefinition;
import com.flowable.dataobject.api.runtime.DataObjectRuntimeService;
import com.flowable.training.dp.repository.AddressRepository;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Action handler that deletes a given address.
 * Could potentially be generified to delete any sort data object, e.g. using the "signal" parameter as a discriminator.
 */
@Component
public class DeleteAddressBot implements BotService {

    private final AddressRepository addressRepository;
    private final DataObjectRuntimeService dataObjectRuntimeService;

    public DeleteAddressBot(AddressRepository addressRepository, DataObjectRuntimeService dataObjectRuntimeService) {
        this.addressRepository = addressRepository;
        this.dataObjectRuntimeService = dataObjectRuntimeService;
    }

    @Override
    public String getKey() {
        return "delete-address-bot";
    }

    @Override
    public String getName() {
        return "Delete Address Bot";
    }

    @Override
    public String getDescription() {
        return "Deletes an address";
    }

    @Override
    public BotActionResult invokeBot(HistoricActionInstance actionInstance, ActionDefinition actionDefinition, Map<String, Object> payload) {
        String lookupId = actionInstance.getScopeId();
        addressRepository.deleteById(lookupId);

        // We used the repository above here. We could also use the DataObjectRuntimeService:
        // dataObjectRuntimeService.deleteDataObject(lookupId, Address.DATA_OBJECT_KEY);
        return new BaseBotActionResult();
    }
}
