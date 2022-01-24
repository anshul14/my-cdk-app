package com.myorg;

import software.amazon.awscdk.core.App;

public final class MyCdkAppApp {
    public static void main(final String[] args) {
        App app = new App();

        new MyCdkAppStack(app, "MyCdkAppStack");

        app.synth();
    }
}
