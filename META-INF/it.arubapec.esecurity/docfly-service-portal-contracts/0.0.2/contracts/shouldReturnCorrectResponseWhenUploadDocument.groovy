package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method "POST"
        headers {
            contentType('application/json')
        }
        url "/serviceportal/sp-resources/Document"
        body(
                [
                        [
                                amount    : anyInteger(),
                                date      : anyNumber(),
                                documentId: anyNonEmptyString(),
                                producer  : [
                                        name: "LIspa"
                                ],
                                size      : anyNumber(),
                                status    : anyOf("CARICATO", "ELIMINATO"),
                                subtype   : [
                                        level2: "DICOM"
                                ],
                                type      : [
                                        previous: false
                                ]
                        ]
                ]
        )
    }

    response {
        status OK()
        headers {
            contentType('application/json')
        }
        body([
                processed: anyInteger(),
                persisted: [
                        [
                                version   : anyInteger(),
                                audit     : [
                                        created  : anyNumber(),
                                        createdBy: anyAlphaNumeric()
                                ],
                                id        : anyPositiveInt(),
                                amount    : anyNumber(),
                                date      : anyNumber(),
                                documentId: anyNonEmptyString(),
                                producer  : [
                                        version: anyNumber(),
                                        id     : anyPositiveInt(),
                                        active : anyBoolean(),
                                        name   : anyNonEmptyString(),
                                        users  : anyInteger()
                                ],
                                size      : anyNumber(),
                                status    : anyNonEmptyString(),
                                subtype   : [
                                        version: anyNumber(),
                                        id     : anyPositiveInt(),
                                        level2 : anyNonEmptyString()
                                ],
                                type      : [
                                        version  : anyNumber(),
                                        id       : anyInteger(),
                                        type1    : anyNonEmptyString(),
                                        previous : anyBoolean(),
                                        stringify: anyNonEmptyString()
                                ]
                        ]
                ]
        ])
    }
}
