package com.doguskar.tasktrackingapplication.facade;

import com.doguskar.tasktrackingapplication.data.TaskData;
import com.doguskar.tasktrackingapplication.requestbody.PostTaskRequestBody;

public interface TaskFacade {
    TaskData add(final PostTaskRequestBody postTaskRequestBody, final Long projectId, final Long taskListsId);
    TaskData update(final PostTaskRequestBody postTaskRequestBody, final Long projectId, final Long taskListsId, final Long taskId);
    boolean delete(final Long projectId, final Long taskListsId, final Long taskId);
    //TaskData findByProjectIdAndTaskListIdAndTaskId(final Long projectId, final Long taskListsId, final Long taskId);
}
