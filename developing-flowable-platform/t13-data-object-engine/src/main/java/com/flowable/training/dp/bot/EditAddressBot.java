package com.flowable.training.dp.bot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowable.action.api.bot.BaseBotActionResult;
import com.flowable.action.api.bot.BotActionResult;
import com.flowable.action.api.bot.BotService;
import com.flowable.action.api.history.HistoricActionInstance;
import com.flowable.action.api.repository.ActionDefinition;
import com.flowable.training.dp.dataobject.Address;
import com.flowable.training.dp.repository.AddressRepository;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Action handler that updates a given address.
 * Here we use the the repository for its simplicity. This method here does not make use of the data object infrastructure.
 */
@Component
public class EditAddressBot implements BotService {

    private final ObjectMapper objectMapper;
    private final AddressRepository addressRepository;

    public EditAddressBot(ObjectMapper objectMapper, AddressRepository addressRepository) {
        this.objectMapper = objectMapper;
        this.addressRepository = addressRepository;
    }


    @Override
    public String getKey() {
        return "edit-address-bot";
    }

    @Override
    public String getName() {
        return "Edit Address Bot";
    }

    @Override
    public String getDescription() {
        return "Edits an address";
    }

    @Override
    public BotActionResult invokeBot(HistoricActionInstance actionInstance, ActionDefinition actionDefinition, Map<String, Object> payload) {
        Map<String, Object> addressMap = (LinkedHashMap) payload.get("address");
        Address address = objectMapper.convertValue(addressMap, Address.class);
        addressRepository.save(address);
        return new BaseBotActionResult();
    }
}
