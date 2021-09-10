const ViewMappingConfig = {
  // global pages
  'com.terapico.caf.viewcomponent.GenericPage': [
    {
      pageName: '/genericpage/generic-page',
      stateAction: 'genericpage/save',
    },
    {
      pageName: '/genericpage/generic-page2',
      stateAction: 'genericpage2/save',
    },
  ],
  'com.terapico.caf.viewcomponent.GenericFormPage': {
    pageName: '/genericform/genericform-page',
    stateAction: 'genericform/save',
  },
  'com.terapico.appview.ListOfPage': [
    {
      pageName: '/listof/listof-page',
      stateAction: ['listofpage/save', 'listofpage2/clear'],
    },
    {
      pageName: '/listof/listof-page2',
      stateAction: ['listofpage2/save', 'listofpage3/clear'],
    },
    {
      pageName: '/listof/listof-page3',
      stateAction: ['listofpage3/save', 'listofpage4/clear'],
    },
    {
      pageName: '/listof/listof-page4',
      stateAction: ['listofpage4/save', 'listofpage5/clear'],
    },
    {
      pageName: '/listof/listof-page5',
      stateAction: ['listofpage5/save', 'listofpage/clear'],
    },
  ],

  'com.terapico.appview.ObjectPickerPage': {
    pageName: '/genericform/object-picker-page',
    stateAction: 'objectPicker/saveInbound',
  },

  'com.terapico.appview.MePage': {
    pageName: '/pages/me/me-page',
    stateAction: 'me/save',
  },
  'com.terapico.appview.ServiceCenterPage': {
    pageName: '/pages/service-center/service-center-page',
    stateAction: 'serviceCenter/save',
  },
  LoginForm: {
    pageName: '/pages/login/login-page',
  },
  'com.terapico.appview.HomePage': {
    pageName: '/pages/home/home-page',
    stateAction: 'home/save',
  },
  'com.terapico.appview.DetailPage': [
    {
      pageName: '/pages/detail/detail-page',
      stateAction: ['detail/save', 'detail2/clear'],
    },
    {
      pageName: '/pages/detail/detail-page2',
      stateAction: ['detail2/save', 'detail3/clear'],
    },
    {
      pageName: '/pages/detail/detail-page3',
      stateAction: ['detail3/save', 'detail4/clear'],
    },
    {
      pageName: '/pages/detail/detail-page4',
      stateAction: ['detail4/save', 'detail/clear'],
    },
  ],
  // end global pages

  'com.mock': [
    {
      pageName: '/pages/listof-page',
      stateAction: 'listofpage/save',
    },
    {
      pageName: '/pages/listof-page2',
      stateAction: 'listofpage2/save',
    },
  ],
};

export default ViewMappingConfig;
