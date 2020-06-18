package com.flowable.training.dp.bot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowable.action.api.bot.BaseBotActionResult;
import com.flowable.action.api.bot.BotActionResult;
import com.flowable.action.api.bot.BotService;
import com.flowable.action.api.history.HistoricActionInstance;
import com.flowable.action.api.intents.Intent;
import com.flowable.action.api.repository.ActionDefinition;
import com.flowable.dataobject.api.runtime.DataObjectInstanceVariableContainer;
import com.flowable.dataobject.api.runtime.DataObjectRuntimeService;
import com.flowable.training.dp.dataobject.Address;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Action handler that creates a new address.
 * Here, we use the DataObjectRuntimeService to create the address.
 * We could potentially use the repository as well.
 */
@Component
public class CreateAddressBot implements BotService {

    private final ObjectMapper objectMapper;
    private final DataObjectRuntimeService dataObjectRuntimeService;

    public CreateAddressBot(ObjectMapper objectMapper, DataObjectRuntimeService dataObjectRuntimeService) {
        this.objectMapper = objectMapper;
        this.dataObjectRuntimeService = dataObjectRuntimeService;
    }

    @Override
    public String getKey() {
        return "create-address-bot";
    }

    @Override
    public String getName() {
        return "Create Address Bot";
    }

    @Override
    public String getDescription() {
        return "Creates addresses";
    }

    @Override
    public BotActionResult invokeBot(HistoricActionInstance actionInstance, ActionDefinition actionDefinition, Map<String, Object> payload) {
        Map<String, Object> addressMap = (LinkedHashMap) payload.get("address");
        Address address = objectMapper.convertValue(addressMap, Address.class);
        DataObjectInstanceVariableContainer dataObject = dataObjectRuntimeService.createDataObjectValueInstanceBuilderByDefinitionKey(Address.DATA_OBJECT_KEY)
                .value(Address.FIELD_TITLE, address.getTitle())
                .value(Address.FIELD_NAME, address.getName())
                .value(Address.FIELD_STREET, address.getStreet())
                .value(Address.FIELD_ZIP_CODE, address.getZipCode())
                .value(Address.FIELD_CITY, address.getCity())
                .value(Address.FIELD_COUNTRY, address.getCountry())
                .create();

        JsonNode result = objectMapper.createObjectNode().put("id", (String)dataObject.getLookupId());

        return new BaseBotActionResult(result, Intent.NOOP);
    }
}
