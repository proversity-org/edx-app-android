package org.proversity.edx.mobile.view.common;

import org.proversity.edx.mobile.model.course.CourseComponent;

/**
 * Created by hanning on 6/9/15.
 */
public interface RunnableCourseComponent extends Runnable{
    CourseComponent getCourseComponent();
}
