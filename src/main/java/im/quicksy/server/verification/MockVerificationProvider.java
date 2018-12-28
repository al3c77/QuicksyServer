/*
 * Copyright 2018 Daniel Gultsch
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.quicksy.server.verification;

import com.google.i18n.phonenumbers.Phonenumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockVerificationProvider implements VerificationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockVerificationProvider.class);

    @Override
    public boolean verify(Phonenumber.PhoneNumber phoneNumber, String pin) {
        return pin != null && pin.length() == 6 && String.valueOf(phoneNumber.getNationalNumber()).startsWith(pin);
    }

    @Override
    public void request(Phonenumber.PhoneNumber phoneNumber, Method method) {
        request(phoneNumber, method, null);
    }

    @Override
    public void request(Phonenumber.PhoneNumber phoneNumber, Method method, String language) {
        LOGGER.info("sending verification SMS to "+phoneNumber+"("+method+") language="+language);
    }
}
