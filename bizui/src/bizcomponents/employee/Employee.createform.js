import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import SelectObject from '../../components/SelectObject'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './Employee.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import EmployeeBase from './Employee.base'
<<<<<<< HEAD

=======
import EmployeeCreateFormBody from './Employee.createformbody'
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  title: '程序员',
  familyName: '张',
  givenName: '文强',
  email: 'share@163.com',
  city: '北京',
  address: '学院路234号',
  cellPhone: '18677778888',
  salaryAccount: '6226 7788 9908 ',
  companyId: 'RSCC000001',
  departmentId: 'LTD000001',
  occupationId: 'OT000001',
  responsibleForId: 'RT000001',
  currentSalaryGradeId: 'SG000001',
}
*/

const imageKeys = [
]


class EmployeeCreateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
	
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

 



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
    const { form, dispatch, submitting, role } = this.props
    const { convertedImagesValues } = this.state
<<<<<<< HEAD

=======
	const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = EmployeeBase
    const {EmployeeService} = GlobalComponents
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    const submitCreateForm = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error)
          return
        }

        const { owner } = this.props
        const imagesValues = mapBackToImageValues(convertedImagesValues)

        const parameters = { ...values, ...imagesValues }
        const cappedRoleName = capFirstChar(role)
        dispatch({
          type: `${owner.type}/add${cappedRoleName}`,
          payload: { id: owner.id, role: role, parameters },
        })
      })
    }
    const submitCreateFormAndContinue = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error)
          return
        }
        
        const { owner } = this.props
        const imagesValues = mapBackToImageValues(convertedImagesValues)
        
        const parameters = { ...values, ...imagesValues }
        dispatch({
          type: `${owner.type}/addEmployee`,
          payload: { id: owner.id, type: 'employee', parameters, continueNext: true },
        })
      })
    }
    
    const goback = () => {
      const { owner } = this.props
<<<<<<< HEAD
      dispatch({
        type: `${owner.type}/goback`,
        payload: { id: owner.id, type: 'employee',listName:'员工列表' },
=======
     
      dispatch({
        type: `${owner.type}/goback`,
        payload: { id: owner.id, type: 'employee',listName:appLocaleName(userContext,"List") },
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      })
    }
    const errors = getFieldsError()
    const getErrorInfo = () => {
      const errorCount = Object.keys(errors).filter(key => errors[key]).length
      if (!errors || errorCount === 0) {
        return null
      }
      // eslint-disable-next-line no-unused-vars
      const scrollToField = (fieldKey) => {
        const labelNode = document.querySelector('label[for="${fieldKey}"]')
        if (labelNode) {
          labelNode.scrollIntoView(true)
        }
      }
      const errorList = Object.keys(errors).map((key) => {
        if (!errors[key]) {
          return null
        }
        return (
          <li key={key} className={styles.errorListItem} onClick={() => scrollToField(key)}>
            <Icon type="cross-circle-o" className={styles.errorIcon} />
            <div className={styles.errorMessage}>{errors[key][0]}</div>
            <div className={styles.errorField}>{fieldLabels[key]}</div>
          </li>
        )
      })
      return (
        <span className={styles.errorIcon}>
          <Popover
<<<<<<< HEAD
            title="表单校验信息"
=======
            title={appLocaleName(userContext,"FieldValidateInfo")}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
            content={errorList}
            overlayClassName={styles.errorPopover}
            trigger="click"
            getPopupContainer={trigger => trigger.parentNode}
          >
            <Icon type="exclamation-circle" />
          </Popover>
          {errorCount}
        </span>
      )
    }
    

    
    
    const tryinit  = (fieldName) => {
      const { owner } = this.props
<<<<<<< HEAD
=======
      if(!owner){
      	return null
      }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
<<<<<<< HEAD
=======
      if(!owner){
      	return true
      }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    const formItemLayout = {
<<<<<<< HEAD
      labelCol: { span: 10 },
      wrapperCol: { span: 14 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
    return (
      <PageHeaderLayout
        title="新建一个员工"
        content="新建一个员工"
        wrapperClassName={styles.advancedForm}
      >
        <Card title="基础信息" className={styles.card} bordered={false}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.title} {...formItemLayout}>
                  {getFieldDecorator('title', {
                    rules: [{ required: true, message: '请输入头衔' }],
                  })(
                    <Input placeholder="请输入头衔" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.familyName} {...formItemLayout}>
                  {getFieldDecorator('familyName', {
                    rules: [{ required: true, message: '请输入姓' }],
                  })(
                    <Input placeholder="请输入姓" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.givenName} {...formItemLayout}>
                  {getFieldDecorator('givenName', {
                    rules: [{ required: true, message: '请输入名' }],
                  })(
                    <Input placeholder="请输入名" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.email} {...formItemLayout}>
                  {getFieldDecorator('email', {
                    rules: [{ required: true, message: '请输入电子邮件' }],
                  })(
                    <Input placeholder="请输入电子邮件" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.city} {...formItemLayout}>
                  {getFieldDecorator('city', {
                    rules: [{ required: true, message: '请输入城市' }],
                  })(
                    <Input placeholder="请输入城市" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.address} {...formItemLayout}>
                  {getFieldDecorator('address', {
                    rules: [{ required: true, message: '请输入地址' }],
                  })(
                    <Input placeholder="请输入地址" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.cellPhone} {...formItemLayout}>
                  {getFieldDecorator('cellPhone', {
                    rules: [{ required: true, message: '请输入手机' }],
                  })(
                    <Input placeholder="请输入手机" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.salaryAccount} {...formItemLayout}>
                  {getFieldDecorator('salaryAccount', {
                    rules: [{ required: true, message: '请输入工资账户' }],
                  })(
                    <Input placeholder="请输入工资账户" />
                  )}
                </Form.Item>
              </Col>

            </Row>
          </Form>
        </Card>



       
        









        <Card title="关联" className={styles.card} bordered={false}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.company} {...formItemLayout}>
                  {getFieldDecorator('companyId', {
                  	initialValue: tryinit('company'),
                    rules: [{ required: true, message: '请输入公司' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('company')}
                    targetType={"company"} 
                    requestFunction={EmployeeService.requestCandidateCompany}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.department} {...formItemLayout}>
                  {getFieldDecorator('departmentId', {
                  	initialValue: tryinit('department'),
                    rules: [{ required: true, message: '请输入部门' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('department')}
                    targetType={"department"} 
                    requestFunction={EmployeeService.requestCandidateDepartment}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.occupation} {...formItemLayout}>
                  {getFieldDecorator('occupationId', {
                  	initialValue: tryinit('occupation'),
                    rules: [{ required: true, message: '请输入职业' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('occupation')}
                    targetType={"occupation"} 
                    requestFunction={EmployeeService.requestCandidateOccupation}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.responsibleFor} {...formItemLayout}>
                  {getFieldDecorator('responsibleForId', {
                  	initialValue: tryinit('responsibleFor'),
                    rules: [{ required: true, message: '请输入负责' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('responsibleFor')}
                    targetType={"responsibleFor"} 
                    requestFunction={EmployeeService.requestCandidateResponsibleFor}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.currentSalaryGrade} {...formItemLayout}>
                  {getFieldDecorator('currentSalaryGradeId', {
                  	initialValue: tryinit('currentSalaryGrade'),
                    rules: [{ required: true, message: '请输入目前工资等级' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('currentSalaryGrade')}
                    targetType={"currentSalaryGrade"} 
                    requestFunction={EmployeeService.requestCandidateCurrentSalaryGrade}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

            </Row>
          </Form>  
        </Card>
=======
      labelCol: { span: 3 },
      wrapperCol: { span: 9 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 3 },
      wrapperCol: { span: 9 },
    }
    
    const internalRenderTitle = () =>{
      const linkComp=<a onClick={goback}  > <Icon type="double-left" style={{marginRight:"10px"}} /> </a>
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}员工</div>)
    }

	return (
      <PageHeaderLayout
        title={internalRenderTitle()}
        content={`${appLocaleName(userContext,"CreateNew")}员工`}
        wrapperClassName={styles.advancedForm}
      >
   			
   		<EmployeeCreateFormBody	 {...this.props} />

>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

        <FooterToolbar>
          {getErrorInfo()}
          <Button type="primary" onClick={submitCreateForm} loading={submitting} htmlType="submit">
<<<<<<< HEAD
            提交
          </Button>
          <Button type="primary" onClick={submitCreateFormAndContinue} loading={submitting}>
            提交并建下一个
          </Button>
          <Button type="danger" onClick={goback} loading={submitting}>
            放弃
          </Button>
        </FooterToolbar>
=======
            {appLocaleName(userContext,"Submit")}
          </Button>
          <Button type="primary" onClick={submitCreateFormAndContinue} loading={submitting}>
            {appLocaleName(userContext,"SubmitAndContinue")}
          </Button>
          <Button type="danger" onClick={goback} loading={submitting}>
            {appLocaleName(userContext,"Discard")}
          </Button>
        </FooterToolbar>
      
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(EmployeeCreateForm))




