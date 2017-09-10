package eu.bittrade.libs.steemj.base.models.operations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steemj.annotations.SignatureRequired;
import eu.bittrade.libs.steemj.base.models.AccountName;
import eu.bittrade.libs.steemj.base.models.Authority;
import eu.bittrade.libs.steemj.base.models.PublicKey;
import eu.bittrade.libs.steemj.enums.OperationType;
import eu.bittrade.libs.steemj.enums.PrivateKeyType;
import eu.bittrade.libs.steemj.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steemj.util.SteemJUtils;

/**
 * This class represents the Steem "account_update_operation" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class AccountUpdateOperation extends AbstractAccountOperation {
    @SignatureRequired(type = PrivateKeyType.OWNER)
    @JsonProperty("account")
    private AccountName account;

    /**
     * Create a new create account update operation. Use this operation to
     * update the keys of an existing account.
     */
    public AccountUpdateOperation() {
        super(false);
    }

    /**
     * Get the account name of the account that has been changed.
     * 
     * @return The account name of the changed account.
     */
    public AccountName getAccount() {
        return account;
    }

    /**
     * Set the account name of the account that has been changed. <b>Notice:</b>
     * The private owner key of this account needs to be stored in the key
     * storage.
     * 
     * @param account
     *            The account name of the account to change.
     */
    public void setAccount(AccountName account) {
        this.account = account;
    }

    /**
     * Get the owner {@link eu.bittrade.libs.steemj.base.models.Authority
     * Authority} of the {@link #account account}.
     * 
     * @return The owner authority.
     */
    @Override
    public Authority getOwner() {
        return owner;
    }

    /**
     * Set the owner {@link eu.bittrade.libs.steemj.base.models.Authority
     * Authority} of the {@link #account account}.
     * 
     * @param owner
     *            The owner authority.
     */
    @Override
    public void setOwner(Authority owner) {
        this.owner = owner;
    }

    /**
     * Get the active {@link eu.bittrade.libs.steemj.base.models.Authority
     * Authority} of the {@link #account account}.
     * 
     * @return The active authority.
     */
    @Override
    public Authority getActive() {
        return active;
    }

    /**
     * Set the active {@link eu.bittrade.libs.steemj.base.models.Authority
     * Authority} of the {@link #account account}.
     * 
     * @param active
     *            The active authority.
     */
    @Override
    public void setActive(Authority active) {
        this.active = active;
    }

    /**
     * Get the posting {@link eu.bittrade.libs.steemj.base.models.Authority
     * Authority} of the {@link #account account}.
     * 
     * @return The posting authority.
     */
    @Override
    public Authority getPosting() {
        return posting;
    }

    /**
     * Set the posting {@link eu.bittrade.libs.steemj.base.models.Authority
     * Authority} of the {@link #account account}.
     * 
     * @param posting
     *            The posting authority.
     */
    @Override
    public void setPosting(Authority posting) {
        this.posting = posting;
    }

    /**
     * Get the memo {@link eu.bittrade.libs.steemj.base.models.PublicKey
     * PublicKey} of the {@link #account account}.
     * 
     * @return The memo key.
     */
    @Override
    public PublicKey getMemoKey() {
        return memoKey;
    }

    /**
     * Set the memo {@link eu.bittrade.libs.steemj.base.models.PublicKey
     * PublicKey} of the {@link #account account}.
     * 
     * @param memoKey
     *            The memo key.
     */
    @Override
    public void setMemoKey(PublicKey memoKey) {
        this.memoKey = memoKey;
    }

    /**
     * Get the json metadata which have been added to this operation.
     * 
     * @return The json metadata which have been added to this operation.
     */
    @Override
    public String getJsonMetadata() {
        return jsonMetadata;
    }

    /**
     * Add json metadata to this operation.
     * 
     * @param jsonMetadata
     *            The json metadata.
     */
    @Override
    public void setJsonMetadata(String jsonMetadata) {
        this.jsonMetadata = jsonMetadata;
    }

    @Override
    public byte[] toByteArray() throws SteemInvalidTransactionException {
        try (ByteArrayOutputStream serializedAccountUpdateOperation = new ByteArrayOutputStream()) {
            serializedAccountUpdateOperation
                    .write(SteemJUtils.transformIntToVarIntByteArray(OperationType.ACCOUNT_UPDATE_OPERATION.ordinal()));
            serializedAccountUpdateOperation.write(this.getAccount().toByteArray());
            serializedAccountUpdateOperation.write(this.getOwner().toByteArray());
            serializedAccountUpdateOperation.write(this.getActive().toByteArray());
            serializedAccountUpdateOperation.write(this.getPosting().toByteArray());
            serializedAccountUpdateOperation.write(this.getMemoKey().toByteArray());
            serializedAccountUpdateOperation.write(SteemJUtils.transformStringToVarIntByteArray(this.jsonMetadata));

            return serializedAccountUpdateOperation.toByteArray();
        } catch (IOException e) {
            throw new SteemInvalidTransactionException(
                    "A problem occured while transforming the operation into a byte array.", e);
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}