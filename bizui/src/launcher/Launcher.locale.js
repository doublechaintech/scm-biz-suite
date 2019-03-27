const launcherEnUS = {};
const launcherZhCN = {};

launcherZhCN.Exit = '退出';
launcherEnUS.Exit = 'Exit';
launcherZhCN.Password = '密码';
launcherEnUS.Password = 'Password';
launcherZhCN.Platform = '平台';
launcherEnUS.Platform = 'Platform';
launcherZhCN.LogIn = '登录';
launcherEnUS.LogIn = 'Log In';
launcherZhCN.Warning = '警告';
launcherEnUS.Warning = 'Warning';
launcherZhCN.NextStep = '下一步';
launcherEnUS.NextStep = 'Next Step';
launcherZhCN.OldPassword = '原密码';
launcherEnUS.OldPassword = 'Old Password';
launcherZhCN.MobilePhone = '手机号';
launcherEnUS.MobilePhone = 'Mobile Phone';
launcherZhCN.NewPassword = '新密码';
launcherEnUS.NewPassword = 'New Password';
launcherZhCN.Username = '用户名';
launcherEnUS.Username = 'Username';
launcherZhCN.VerificationCode = '验证码';
launcherEnUS.VerificationCode = 'Verification Code';
launcherZhCN.ChangePassword = '修改密码';
launcherEnUS.ChangePassword = 'Change Password';
launcherZhCN.ChangedSuccess = '修改成功';
launcherEnUS.ChangedSuccess = 'Changed Success';
launcherZhCN.PasswordError = '密码出错';
launcherEnUS.PasswordError = 'Password Error';
launcherZhCN.ForgetPassword = '忘记密码';
launcherEnUS.ForgetPassword = 'Forget Password';
launcherZhCN.Success = '执行成功';
launcherEnUS.Success = 'Success';
launcherZhCN.MoreFeatures = '更多特性';
launcherEnUS.MoreFeatures = 'More Features';
launcherZhCN.ChangePassword = '更新密码';
launcherEnUS.x = 'Change Password';
launcherZhCN.SignInError = '登录出错';
launcherEnUS.SignInError = 'Sign In Error';
launcherZhCN.ThisPhoneNumber = '该手机号';
launcherEnUS.ThisPhoneNumber = 'This Phone Number';
launcherZhCN.InputError = '输入错误';
launcherEnUS.InputError = 'Input Error';
launcherZhCN.ReturnToHome = '返回主页';
launcherEnUS.ReturnToHome = 'Return To Home';
launcherZhCN.PleaseInputYourPassword = '请输入密码';
launcherEnUS.PleaseInputYourPassword = 'Please Input Your Password';
launcherZhCN.VerificationCodeError = '验证码错误';
launcherEnUS.VerificationCodeError = 'Verification Code Error';
launcherZhCN.PasswordsDontMatch = '密码输入不同';
launcherEnUS.PasswordsDontMatch = 'Passwords Dont Match';
launcherZhCN.PleaseContractAdmin = '请联系管理员';
launcherEnUS.PleaseContractAdmin = 'Please Contract Admin';
launcherZhCN.InputPhoneNumber = '请输入手机号';
launcherEnUS.InputPhoneNumber = 'Input Phone Number';
launcherZhCN.InputNewPassword = '请输入新密码';
launcherEnUS.InputNewPassword = 'Input New Password';
launcherZhCN.PleaseInputOldPass = '请输入旧密码';
launcherEnUS.PleaseInputOldPass = 'Please Input Old Pass ';
launcherZhCN.PleaseInputUsername = '请输入用户名';
launcherEnUS.PleaseInputUsername = 'Please Input Username';
launcherZhCN.PleaseInputVerificationCode = '请输入验证码';
launcherEnUS.PleaseInputVerificationCode = 'Please Input Verification Code';
launcherZhCN.PleaseInputPass = '重新输入密码';
launcherEnUS.PleaseInputPass = 'Please Input Pass';
launcherZhCN.PleaseInputPassAgain = '再次输入新密码';
launcherEnUS.PleaseInputPassAgain = 'Please Input Pass Again';
launcherZhCN.PleaseSignInAgain = '请尝试重新登录';
launcherEnUS.PleaseSignInAgain = 'Please Sign In Again';
launcherZhCN.PleaseInputNewPass = '请重新输入密码';
launcherEnUS.PleaseInputNewPass = 'Please Input New Pass ';
launcherZhCN.Passworddoesnotmatch = '两次密码输入不同';
launcherEnUS.Passworddoesnotmatch = 'Password does not match';
launcherZhCN.CouldNotFindUser = '关联的用户找不到';
launcherEnUS.CouldNotFindUser = 'Could Not Find User';
launcherZhCN.PleaseInputNewPass = '请再次输入新密码';
launcherEnUS.PleaseInputNewPass = 'Please Input New Pass ';
launcherZhCN.Passwordsdonotmatch = '两次输入的密码不一致';
launcherEnUS.Passwordsdonotmatch = 'Passwords do not match';
launcherZhCN.UseYourNewPasswordtoSignIn = '修改密码成功，请使用您的新密码';
launcherEnUS.UseYourNewPasswordtoSignIn = 'Use Your New Password to Sign In';

const oneOf = (value, candidates) => {
  return candidates.filter(item => item == value).length > 0;
};

const isLegalLocale = value => {
  return oneOf(value, ['enUS', 'zhCN']);
};

const determinLocale = userContext => {
  const defaultLocale = 'zhCN';
  if (userContext == null) {
    const userLang = navigator.language || navigator.userLanguage;
    const trimedLocale = userLang.replace('-', '');
    if (isLegalLocale(trimedLocale)) {
      return trimedLocale;
    }
    return defaultLocale
  }
  
  const userLocale = userContext.userLocale;
  if (isLegalLocale(userLocale)) {
    return userLocale;
  }

  return defaultLocale;
};

const internalLocaleName = (key, locale) => {
  if (locale == 'enUS') {
    return launcherEnUS[key];
  }
  if (locale == 'zhCN') {
    return launcherZhCN[key];
  }
  return null;
};

const localeName = (key, locale) => {
  const value = internalLocaleName(key, locale);
  if (value == null) {
    return key + 'NeedToFix';
  }
  return value;
};

const defaultLocaleName = (userContext, key) => {
  const locale = determinLocale(userContext);
  return localeName(key, locale);
};

export default defaultLocaleName;

/*


密码|Password
平台|Platform
登录|Login
警告|Warning
下一步|Next Step
原密码|Old Password
手机号|Mobile Phone
新密码|New Password
用户名|Username
验证码|Verification Code
修改密码|Change password
修改成功|Changed Success
密码出错|Password Error
忘记密码|Forget Password
执行成功|Success
更多特性|More Features
更新密码|Change Password
登录出错|Sign In Error
该手机号|This Phone Number
输入错误|Input Error
返回主页|Return To Home
请输入密码|Please Input Your Password
验证码错误|Verification Code Error
密码输入不同|Passwords do not match
请联系管理员|Please contract admin
请输入手机号|Input Phone Number
请输入新密码|Input New Password
请输入旧密码|Please Input Old Pass 
请输入用户名|Please Input Username
请输入验证码|Please Input Verification Code
重新输入密码|Please Input Pass 
再次输入新密码|Please Input Pass Again
请尝试重新登录|Please Sign In Again
请重新输入密码|Please Input New Pass 
两次密码输入不同|Password does not match
关联的用户找不到|Could Not Find User
请再次输入新密码|Please Input New Pass 
两次输入的密码不一致|Passwords do not match
修改密码成功，请使用您的新密码|Password Update Success
*/
