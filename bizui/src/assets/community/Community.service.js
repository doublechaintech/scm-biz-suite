import { get, post } from '../../axios/tools';

const getURLPrefix = () => {
  const url = new URL(window.location);
  if (url.hostname === 'localhost') {
    return `http://${url.hostname}:8080/naf/`;
  }
  return `${url.origin}/bbt/`;
};

const PREFIX = getURLPrefix();

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}communityManager/view/${targetObjectId}/`,
  });
};

const joinParameters = (parameters) => {
  const obj = parameters; // {value1: 'prop1', value2: 'prop2', value3: 'prop3'};
  const arr = [];
  for (const key in obj) {
    if (obj.hasOwnProperty(key)) {
      arr.push(`${key}=${encodeURIComponent(obj[key])}`);
    }
  }
  const result = arr.join(';');
  return result;
};

const joinPostParameters = (parameters) => {
  const obj = parameters; // {value1: 'prop1', value2: 'prop2', value3: 'prop3'};
  const arr = [];
  for (const key in obj) {
    if (obj.hasOwnProperty(key)) {
      const value = obj[key]
      if (!Array.isArray(value)) {
        arr.push(key + '=' + encodeURIComponent(value));
      }
      for (const subKey in value) {
        const subvalue = value[subKey];
        arr.push(key + '=' + encodeURIComponent(subvalue));
      }
    }
  };
  const result = arr.join('&');
  return result;
};

const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters);
  return get({
    url: `${PREFIX}communityManager/loadCommunity/${targetObjectId}/${parametersExpr}/`,
  });
};



const addInvitationCode = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/addInvitationCode/communityId/name/code/used/tokensExpr/`;
  const requestParameters = { ...parameters, tokensExpr: 'none' };

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const updateInvitationCode = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/updateInvitationCodeProperties/communityId/id/name/code/used/tokensExpr/`;
  const communityId = targetObjectId;
  const requestParameters = { ...parameters, communityId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const removeInvitationCodeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/removeInvitationCodeList/communityId/invitationCodeIds/tokensExpr/`;
  const requestParameters = { ...parameters, communityId: targetObjectId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};


const addHomePage = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/addHomePage/communityId/title/tokensExpr/`;
  const requestParameters = { ...parameters, tokensExpr: 'none' };

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const updateHomePage = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/updateHomePageProperties/communityId/id/title/tokensExpr/`;
  const communityId = targetObjectId;
  const requestParameters = { ...parameters, communityId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const removeHomePageList = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/removeHomePageList/communityId/homePageIds/tokensExpr/`;
  const requestParameters = { ...parameters, communityId: targetObjectId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};


const addEncyclopediaItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/addEncyclopediaItem/communityId/title/publishTime/content/homePageId/tokensExpr/`;
  const requestParameters = { ...parameters, tokensExpr: 'none' };

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const updateEncyclopediaItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/updateEncyclopediaItemProperties/communityId/id/title/publishTime/content/tokensExpr/`;
  const communityId = targetObjectId;
  const requestParameters = { ...parameters, communityId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const removeEncyclopediaItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/removeEncyclopediaItemList/communityId/encyclopediaItemIds/tokensExpr/`;
  const requestParameters = { ...parameters, communityId: targetObjectId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};


const addTaskPage = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/addTaskPage/communityId/title/currentKey/tokensExpr/`;
  const requestParameters = { ...parameters, tokensExpr: 'none' };

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const updateTaskPage = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/updateTaskPageProperties/communityId/id/title/currentKey/tokensExpr/`;
  const communityId = targetObjectId;
  const requestParameters = { ...parameters, communityId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const removeTaskPageList = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/removeTaskPageList/communityId/taskPageIds/tokensExpr/`;
  const requestParameters = { ...parameters, communityId: targetObjectId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};


const addCommunityUser = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/addCommunityUser/communityId/mobile/nickName/gender/userType/avatar/birthday/experiencePoint/bonusPoint/city/status/hideInfo/administrator/tokensExpr/`;
  const requestParameters = { ...parameters, tokensExpr: 'none' };

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const updateCommunityUser = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/updateCommunityUserProperties/communityId/id/mobile/nickName/gender/userType/avatar/birthday/experiencePoint/bonusPoint/city/status/hideInfo/administrator/tokensExpr/`;
  const communityId = targetObjectId;
  const requestParameters = { ...parameters, communityId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const removeCommunityUserList = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/removeCommunityUserList/communityId/communityUserIds/tokensExpr/`;
  const requestParameters = { ...parameters, communityId: targetObjectId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};


const addTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/addTask/communityId/title/selectedTask/content/creatorId/homePageId/taskPageId/videoUrl/coverImagePath1/coverImagePath2/coverImagePath3/imagePath1/imagePath2/imagePath3/imagePath4/imagePath5/creatorBonus/additionalBonus/likeByCurrentUser/repliedByCurrentUser/tokensExpr/`;
  const requestParameters = { ...parameters, tokensExpr: 'none' };

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const updateTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/updateTaskProperties/communityId/id/title/selectedTask/content/videoUrl/coverImagePath1/coverImagePath2/coverImagePath3/imagePath1/imagePath2/imagePath3/imagePath4/imagePath5/creatorBonus/additionalBonus/likeByCurrentUser/repliedByCurrentUser/tokensExpr/`;
  const communityId = targetObjectId;
  const requestParameters = { ...parameters, communityId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const removeTaskList = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/removeTaskList/communityId/taskIds/tokensExpr/`;
  const requestParameters = { ...parameters, communityId: targetObjectId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};


const addGroupPage = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/addGroupPage/communityId/title/currentGroupName/tokensExpr/`;
  const requestParameters = { ...parameters, tokensExpr: 'none' };

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const updateGroupPage = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/updateGroupPageProperties/communityId/id/title/currentGroupName/tokensExpr/`;
  const communityId = targetObjectId;
  const requestParameters = { ...parameters, communityId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const removeGroupPageList = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/removeGroupPageList/communityId/groupPageIds/tokensExpr/`;
  const requestParameters = { ...parameters, communityId: targetObjectId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};


const addThread = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/addThread/communityId/title/displayOrder/eventTime/registrationStopTime/eventLocation/city/communityGroup/threadType/creatorId/homePageId/groupPageId/videoUrl/coverImagePath1/coverImagePath2/coverImagePath3/imagePath1/imagePath2/imagePath3/imagePath4/imagePath5/content/likeByCurrentUser/repliedByCurrentUser/registeredByCurrentUser/tokensExpr/`;
  const requestParameters = { ...parameters, tokensExpr: 'none' };

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const updateThread = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/updateThreadProperties/communityId/id/title/displayOrder/eventTime/registrationStopTime/eventLocation/city/communityGroup/threadType/videoUrl/coverImagePath1/coverImagePath2/coverImagePath3/imagePath1/imagePath2/imagePath3/imagePath4/imagePath5/content/likeByCurrentUser/repliedByCurrentUser/registeredByCurrentUser/tokensExpr/`;
  const communityId = targetObjectId;
  const requestParameters = { ...parameters, communityId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};

const removeThreadList = (targetObjectId, parameters) => {
  const url = `${PREFIX}communityManager/removeThreadList/communityId/threadIds/tokensExpr/`;
  const requestParameters = { ...parameters, communityId: targetObjectId, tokensExpr: 'none' };
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' };
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  });
};


const CommunityService = { view,
load,
addInvitationCode,
addHomePage,
addEncyclopediaItem,
addTaskPage,
addCommunityUser,
addTask,
addGroupPage,
addThread,
updateInvitationCode,
updateHomePage,
updateEncyclopediaItem,
updateTaskPage,
updateCommunityUser,
updateTask,
updateGroupPage,
updateThread,
removeInvitationCodeList,
removeHomePageList,
removeEncyclopediaItemList,
removeTaskPageList,
removeCommunityUserList,
removeTaskList,
removeGroupPageList,
removeThreadList };
export default CommunityService;

