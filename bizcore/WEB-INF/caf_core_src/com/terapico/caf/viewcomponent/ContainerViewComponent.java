package com.terapico.caf.viewcomponent;

/**
 * 容器组件。
 * <p>
 * componentType=container <br>
 * containerType=simple</br>
 * </p>
 * 
 * type="container". content 通常为空。
 * 这个只是包装某一组对象，例如一个输入框还要配个label，就把他们对应的组件放到一个container里。
 * 
 * @author clariones
 *
 */
public class ContainerViewComponent extends BaseViewComponent {
    /**
     * 容器的类型。 可用值包括：
     * <ol>
     * <li>simple:普通容器，通常是为了组合一套组件，给与ID，方便做互动；或者方便做排版。</li>
     * <li>form：表单。通常是为了组合若干个FormField</li>
     * </ol>
     */
    protected String containerType = "simple";
    protected String targetId;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public ContainerViewComponent() {
        this(null);
    }

    public ContainerViewComponent(String classes) {
        super();
        this.setClasses(classes);
        this.setComponentType("container");
        this.setBeContaniner(true);
    }

	@Override
	protected String getNodeHashcodeStr() {
		return super.getNodeHashcodeStr()+this.getContainerType()+";";
	}

    
}
