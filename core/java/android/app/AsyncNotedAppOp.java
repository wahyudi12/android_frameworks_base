/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.app;

import android.annotation.IntRange;
import android.annotation.NonNull;
import android.annotation.Nullable;
import android.os.Parcelable;

import com.android.internal.annotations.Immutable;
import com.android.internal.util.DataClass;

/**
 * When an {@link AppOpsManager#noteOp(String, int, String, String, String) app-op is noted} and the
 * app the app-op is noted for has a {@link AppOpsManager.AppOpsCollector} registered the note-event
 * needs to be delivered to the collector. Usually this is done via an {@link SyncNotedAppOp}, but
 * in some cases this is not possible. In this case an {@link AsyncNotedAppOp} is send to the system
 * server and then forwarded to the {@link AppOpsManager.AppOpsCollector} in the app.
 */
@Immutable
@DataClass(genEqualsHashCode = true,
        genAidl = true,
        genHiddenConstructor = true)
// - We don't expose the opCode, but rather the public name of the op, hence use a non-standard
//   getter
@DataClass.Suppress({"getOpCode"})
public final class AsyncNotedAppOp implements Parcelable {
    /** Op that was noted */
    private final @IntRange(from = 0, to = AppOpsManager._NUM_OP - 1) int mOpCode;

    /** Uid that noted the op */
    private final @IntRange(from = 0) int mNotingUid;

    /** {@link android.content.Context#createFeatureContext Feature} in the app */
    private final @Nullable String mFeatureId;

    /** Message associated with the noteOp. This message is set by the app noting the op */
    private final @NonNull String mMessage;

    /** Milliseconds since epoch when the op was noted */
    private final @IntRange(from = 0) long mTime;

    /**
     * @return Op that was noted.
     */
    public @NonNull String getOp() {
        return AppOpsManager.opToPublicName(mOpCode);
    }



    // Code below generated by codegen v1.0.14.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/frameworks/base/core/java/android/app/AsyncNotedAppOp.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    /**
     * Creates a new AsyncNotedAppOp.
     *
     * @param opCode
     *   Op that was noted
     * @param notingUid
     *   Uid that noted the op
     * @param featureId
     *   {@link android.content.Context#createFeatureContext Feature} in the app
     * @param message
     *   Message associated with the noteOp. This message is set by the app noting the op
     * @param time
     *   Milliseconds since epoch when the op was noted
     * @hide
     */
    @DataClass.Generated.Member
    public AsyncNotedAppOp(
            @IntRange(from = 0, to = AppOpsManager._NUM_OP - 1) int opCode,
            @IntRange(from = 0) int notingUid,
            @Nullable String featureId,
            @NonNull String message,
            @IntRange(from = 0) long time) {
        this.mOpCode = opCode;
        com.android.internal.util.AnnotationValidations.validate(
                IntRange.class, null, mOpCode,
                "from", 0,
                "to", AppOpsManager._NUM_OP - 1);
        this.mNotingUid = notingUid;
        com.android.internal.util.AnnotationValidations.validate(
                IntRange.class, null, mNotingUid,
                "from", 0);
        this.mFeatureId = featureId;
        this.mMessage = message;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mMessage);
        this.mTime = time;
        com.android.internal.util.AnnotationValidations.validate(
                IntRange.class, null, mTime,
                "from", 0);

        // onConstructed(); // You can define this method to get a callback
    }

    /**
     * Uid that noted the op
     */
    @DataClass.Generated.Member
    public @IntRange(from = 0) int getNotingUid() {
        return mNotingUid;
    }

    /**
     * {@link android.content.Context#createFeatureContext Feature} in the app
     */
    @DataClass.Generated.Member
    public @Nullable String getFeatureId() {
        return mFeatureId;
    }

    /**
     * Message associated with the noteOp. This message is set by the app noting the op
     */
    @DataClass.Generated.Member
    public @NonNull String getMessage() {
        return mMessage;
    }

    /**
     * Milliseconds since epoch when the op was noted
     */
    @DataClass.Generated.Member
    public @IntRange(from = 0) long getTime() {
        return mTime;
    }

    @Override
    @DataClass.Generated.Member
    public boolean equals(@Nullable Object o) {
        // You can override field equality logic by defining either of the methods like:
        // boolean fieldNameEquals(AsyncNotedAppOp other) { ... }
        // boolean fieldNameEquals(FieldType otherValue) { ... }

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("unchecked")
        AsyncNotedAppOp that = (AsyncNotedAppOp) o;
        //noinspection PointlessBooleanExpression
        return true
                && mOpCode == that.mOpCode
                && mNotingUid == that.mNotingUid
                && java.util.Objects.equals(mFeatureId, that.mFeatureId)
                && java.util.Objects.equals(mMessage, that.mMessage)
                && mTime == that.mTime;
    }

    @Override
    @DataClass.Generated.Member
    public int hashCode() {
        // You can override field hashCode logic by defining methods like:
        // int fieldNameHashCode() { ... }

        int _hash = 1;
        _hash = 31 * _hash + mOpCode;
        _hash = 31 * _hash + mNotingUid;
        _hash = 31 * _hash + java.util.Objects.hashCode(mFeatureId);
        _hash = 31 * _hash + java.util.Objects.hashCode(mMessage);
        _hash = 31 * _hash + Long.hashCode(mTime);
        return _hash;
    }

    @Override
    @DataClass.Generated.Member
    public void writeToParcel(@NonNull android.os.Parcel dest, int flags) {
        // You can override field parcelling by defining methods like:
        // void parcelFieldName(Parcel dest, int flags) { ... }

        byte flg = 0;
        if (mFeatureId != null) flg |= 0x4;
        dest.writeByte(flg);
        dest.writeInt(mOpCode);
        dest.writeInt(mNotingUid);
        if (mFeatureId != null) dest.writeString(mFeatureId);
        dest.writeString(mMessage);
        dest.writeLong(mTime);
    }

    @Override
    @DataClass.Generated.Member
    public int describeContents() { return 0; }

    /** @hide */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @DataClass.Generated.Member
    /* package-private */ AsyncNotedAppOp(@NonNull android.os.Parcel in) {
        // You can override field unparcelling by defining methods like:
        // static FieldType unparcelFieldName(Parcel in) { ... }

        byte flg = in.readByte();
        int opCode = in.readInt();
        int notingUid = in.readInt();
        String featureId = (flg & 0x4) == 0 ? null : in.readString();
        String message = in.readString();
        long time = in.readLong();

        this.mOpCode = opCode;
        com.android.internal.util.AnnotationValidations.validate(
                IntRange.class, null, mOpCode,
                "from", 0,
                "to", AppOpsManager._NUM_OP - 1);
        this.mNotingUid = notingUid;
        com.android.internal.util.AnnotationValidations.validate(
                IntRange.class, null, mNotingUid,
                "from", 0);
        this.mFeatureId = featureId;
        this.mMessage = message;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mMessage);
        this.mTime = time;
        com.android.internal.util.AnnotationValidations.validate(
                IntRange.class, null, mTime,
                "from", 0);

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public static final @NonNull Parcelable.Creator<AsyncNotedAppOp> CREATOR
            = new Parcelable.Creator<AsyncNotedAppOp>() {
        @Override
        public AsyncNotedAppOp[] newArray(int size) {
            return new AsyncNotedAppOp[size];
        }

        @Override
        public AsyncNotedAppOp createFromParcel(@NonNull android.os.Parcel in) {
            return new AsyncNotedAppOp(in);
        }
    };

    @DataClass.Generated(
            time = 1578321462996L,
            codegenVersion = "1.0.14",
            sourceFile = "frameworks/base/core/java/android/app/AsyncNotedAppOp.java",
            inputSignatures = "private final @android.annotation.IntRange(from=0L, to=93L) int mOpCode\nprivate final @android.annotation.IntRange(from=0L) int mNotingUid\nprivate final @android.annotation.Nullable java.lang.String mFeatureId\nprivate final @android.annotation.NonNull java.lang.String mMessage\nprivate final @android.annotation.IntRange(from=0L) long mTime\npublic @android.annotation.NonNull java.lang.String getOp()\nclass AsyncNotedAppOp extends java.lang.Object implements [android.os.Parcelable]\n@com.android.internal.util.DataClass(genEqualsHashCode=true, genAidl=true, genHiddenConstructor=true)")
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}
