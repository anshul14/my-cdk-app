package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Duration;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.subscriptions.SqsSubscription;
import software.amazon.awscdk.services.sqs.Queue;

public class MyCdkAppStack extends Stack {
    public MyCdkAppStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public MyCdkAppStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        final Queue queue = Queue.Builder.create(this, "MyCdkAppQueue")
                .visibilityTimeout(Duration.seconds(300))
                .build();

        final Topic topic = Topic.Builder.create(this, "MyCdkAppTopic")
            .displayName("My First Topic Yeah")
            .build();

        topic.addSubscription(new SqsSubscription(queue));
    }
}
